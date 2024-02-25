package id.my.hendisantika.springbootthymeleafproducts.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-thymeleaf-products
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/25/24
 * Time: 11:23
 * To change this template use File | Settings | File Templates.
 */
@RestControllerAdvice
public class GlobalHandlerException {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalHandlerException.class);

    @ExceptionHandler(DataIsEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleDataIsEmpty(DataIsEmptyException e) {
        LOGGER.info(e.getMessage());
        return ResponseEntity.notFound().build();
    }
}
