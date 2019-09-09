package com.pcz.service.impl;

import com.pcz.dao.AppointmentDao;
import com.pcz.dao.BookDao;
import com.pcz.dto.AppointExecution;
import com.pcz.entity.Appointment;
import com.pcz.entity.Book;
import com.pcz.enums.AppointStateEnum;
import com.pcz.exception.AppointException;
import com.pcz.exception.NoNumberException;
import com.pcz.exception.RepeatException;
import com.pcz.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author picongzhi
 */
@Service
public class BookServiceImpl implements BookService {
    private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Resource
    private BookDao bookDao;

    @Resource
    private AppointmentDao appointmentDao;

    @Override
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getList() {
        return bookDao.queryAll(0, 1000);
    }

    /**
     * 使用注解控制事务方法的优点：
     * 1. 开发团队达成一致约定，明确标注事务方法的编程风格
     * 2. 保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3. 不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    @Transactional
    @Override
    public AppointExecution appoint(long bookId, long studentId) {
        try {
            int updated = bookDao.reduceNumber(bookId);
            if (updated <= 0) {
                throw new NoNumberException("no number");
            } else {
                int inserted = appointmentDao.insertAppointment(bookId, studentId);
                if (inserted <= 0) {
                    throw new RepeatException("repeat appoint");
                } else {
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
                }
            }
        } catch (NoNumberException | RepeatException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppointException("appoint inner error: " + e.getMessage());
        }
    }
}
