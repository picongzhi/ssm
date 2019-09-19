package com.pcz.mapper;

import com.pcz.entity.Book;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author picongzhi
 */
public interface BookMapper extends Mapper<Book>, MySqlMapper<Book> {
    /**
     * 通过ID查询单本图书
     * @param id ID
     * @return Book
     */
    Book queryById(long id);

    /**
     * 查询所有图书
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return List<Book>
     */
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 减少馆藏数量
     * @param bookId ID
     * @return 影响行数
     */
    int reduceNumber(long bookId);
}
