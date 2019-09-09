package com.pcz.service.impl;

import com.pcz.BaseTest;
import com.pcz.dto.AppointExecution;
import com.pcz.entity.Book;
import com.pcz.service.BookService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class BookServiceImplTest extends BaseTest {
    @Resource
    private BookService bookService;

    @Test
    public void testGetList() {
        List<Book> books = bookService.getList();
        System.out.println(books);
    }

    @Test
    public void testAppoint() {
        long bookId = 1001;
        long studentId = 12345678910L;
        AppointExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
    }
}
