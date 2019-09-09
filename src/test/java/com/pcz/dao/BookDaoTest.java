package com.pcz.dao;

import com.pcz.BaseTest;
import com.pcz.dao.BookDao;
import com.pcz.entity.Book;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class BookDaoTest extends BaseTest {
    @Resource
    private BookDao bookDao;

    @Test
    public void testQueryById() {
        long bookId = 1000;
        Book book = bookDao.queryById(bookId);
        System.out.println(book);
    }

    @Test
    public void testQueryAll() {
        List<Book> books = bookDao.queryAll(0, 4);
        books.forEach(System.out::println);
    }

    @Test
    public void testReduceNumber() {
        long bookId = 1000;
        int updated = bookDao.reduceNumber(bookId);
        System.out.println("updated = " + updated);
    }
}
