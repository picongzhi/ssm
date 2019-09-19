package com.pcz.mapper;

import com.pcz.entity.Appointment;
import com.pcz.entity.Book;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author picongzhi
 */
public interface AppointmentMapper extends Mapper<Book>, MySqlMapper<Book> {
    /**
     * 插入预约图书记录
     * @param bookId bookId
     * @param studentId studentId
     * @return 插入的行数
     */
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    /**
     * 通过主键查询预约图书记录，并且携带图书实体
     * @param bookId bookId
     * @param studentId studentId
     * @return Appointment
     */
    Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);
}
