package com.pcz.service;

import com.pcz.dto.AppointExecution;
import com.pcz.entity.Book;

import java.util.List;

public interface BookService {
    /**
     * 查询一本图书
     *
     * @param bookId bookId
     * @return Book
     */
    Book getById(long bookId);

    /**
     * 查询所有图书
     *
     * @return List<Book>
     */
    List<Book> getList();

    /**
     * 预约图书
     *
     * @param bookId    bookId
     * @param studentId studentId
     * @return AppointExecution
     */
    AppointExecution appoint(long bookId, long studentId);
}
