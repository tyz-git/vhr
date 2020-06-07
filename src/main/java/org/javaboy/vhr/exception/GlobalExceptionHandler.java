package org.javaboy.vhr.exception;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.javaboy.vhr.model.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @author: TongYaZhou
 * @create: 2020-06-07 12:02
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException sqlException) {
        if (sqlException instanceof MySQLIntegrityConstraintViolationException) {
            return RespBean.error("此数据有关联数据，操作失败!");
        }
        return RespBean.error("数据库异常!");
    }
}
