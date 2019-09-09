package com.pcz.web;

import com.pcz.dto.AppointExecution;
import com.pcz.dto.Result;
import com.pcz.entity.Book;
import com.pcz.enums.AppointStateEnum;
import com.pcz.exception.NoNumberException;
import com.pcz.exception.RepeatException;
import com.pcz.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author picongzhi
 */
@RestController
@Api("图书")
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Resource
    private BookService bookService;

    @ApiOperation(value = "获取图书列表", httpMethod = "GET")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<Book>> list() {
        List<Book> list = bookService.getList();
        return new Result<>(true, list);
    }

    @ApiOperation(value = "获取图书详情", httpMethod = "GET")
    @RequestMapping(value = "{bookId}/detail", method = RequestMethod.GET)
    @ResponseBody
    public Result<Book> detail(@ApiParam(name = "bookId", value = "图书ID", required = true)
                               @PathVariable("bookId") Long bookId) {
        if (null == bookId) {
            return new Result<>(false, "empty book id");
        }

        Book book = bookService.getById(bookId);
        if (null == book) {
            return new Result<>(false, "not found");
        }

        return new Result<>(true, book);
    }

    @ApiOperation(value = "预定图书", httpMethod = "POST")
    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST)
    @ResponseBody
    public Result<AppointExecution> appoint(@ApiParam(name = "bookId", value = "图书ID", required = true)
                                            @PathVariable("bookId") Long bookId,
                                            @ApiParam(name = "studentId", value = "学号", required = true)
                                            @RequestParam("studentId") Long studentId) {
        if (null == studentId || studentId.equals("")) {
            return new Result<>(false, "学号不能为空");
        }

        AppointExecution execution = null;
        try {
            execution = bookService.appoint(bookId, studentId);
        } catch (NoNumberException e) {
            execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        } catch (RepeatException e) {
            execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
        } catch (Exception e) {
            execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
        }

        return new Result<>(true, execution);
    }
}
