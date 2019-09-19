package com.pcz.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcz.BaseTest;
import com.pcz.entity.Book;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class BookMapperTest extends BaseTest {
    @Resource
    private BookMapper bookMapper;

    @Test
    public void testQueryById() {
        long bookId = 1000L;
        Book book = bookMapper.queryById(bookId);
        System.out.println(book);
    }

    @Test
    public void testSelectAll() {
        List<Book> books = bookMapper.selectAll();
        int count = bookMapper.selectCount(null);
        System.out.println(count);
        System.out.println(books);
    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        book.setBookId(1000L);
        Book one = bookMapper.selectOne(book);
        System.out.println(one);
    }

    @Test
    public void testReduceNumber() {
        long bookId = 1000;
        int updated = bookMapper.reduceNumber(bookId);
        System.out.println("updated = " + updated);
    }

    @Test
    public void testPageHelper() {
        int currentPage = 1;
        int pageSize = 2;
        PageHelper.startPage(currentPage, pageSize);

        List<Book> bookList = bookMapper.selectAll();
        PageInfo<Book> bookPageInfo = new PageInfo<>(bookList);

        System.out.println(bookPageInfo);
    }
}
