package com.pcz.mapper;

import com.pcz.BaseTest;
import com.pcz.entity.Appointment;
import org.junit.Test;

import javax.annotation.Resource;

public class AppointmentMapperTest extends BaseTest {
    @Resource
    private AppointmentMapper appointmentMapper;

    @Test
    public void testInsertAppointment() {
        long bookId = 1000;
        long studentId = 12345678910L;
        int inserted = appointmentMapper.insertAppointment(bookId, studentId);
        System.out.println("inserted = " + inserted);
    }

    @Test
    public void testQueryByKeyWithBook() {
        long bookId = 1000;
        long studentId = 12345678910L;
        Appointment appointment = appointmentMapper.queryByKeyWithBook(bookId, studentId);
        System.out.println(appointment);
        System.out.println(appointment.getBook());
    }
}
