package com.pcz.dao;

import com.pcz.BaseTest;
import com.pcz.dao.AppointmentDao;
import com.pcz.entity.Appointment;
import org.junit.Test;

import javax.annotation.Resource;

public class AppointmentDaoTest extends BaseTest {
    @Resource
    private AppointmentDao appointmentDao;

    @Test
    public void testInsertAppointment() {
        long bookId = 1000;
        long studentId = 12345678910L;
        int inserted = appointmentDao.insertAppointment(bookId, studentId);
        System.out.println("inserted = " + inserted);
    }

    @Test
    public void testQueryByKeyWithBook() {
        long bookId = 1000;
        long studentId = 12345678910L;
        Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
        System.out.println(appointment);
        System.out.println(appointment.getBook());
    }
}
