package com.pcz.dao;

import com.pcz.entity.Appointment;
import org.apache.ibatis.annotations.Param;

/**
 * @author picongzhi
 */
public interface AppointmentDao {
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
