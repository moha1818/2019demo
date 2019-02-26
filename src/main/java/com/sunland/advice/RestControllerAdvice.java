package com.sunland.advice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sunland.dto.RestResponse;
import com.sunland.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * The type Rest controller advice.
 */
@ControllerAdvice(basePackages = {"com.sunland.controller"})
public class RestControllerAdvice {


    /**
     * Handle exception rest response.
     *
     * @param e the e
     * @return the rest response
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResponse<String> handleException(Exception e) {
        return new RestResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), "");
    }

    /**
     * Handle bad request exception rest response.
     *
     * @param e the e
     * @return the rest response
     */
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse<String> handleBadRequestException(Exception e) {
        return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "");
    }

    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResponse<String> handleBizException(Exception e) {
        return new RestResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), "");
    }

    /**
     * Handle http message not readable exception exception rest response.
     *
     * @param e the e
     * @return the rest response
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse<String> handleHttpMessageNotReadableExceptionException(Exception e) {
        return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "");
    }

    /**
     * Handle servlet exception exception rest response.
     *
     * @param e the e
     * @return the rest response
     */
    @ExceptionHandler(ServletException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse<String> handleServletExceptionException(Exception e) {
        return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "");
    }

    /**
     * Handle permission exception rest response.
     *
     * @param e the e
     * @return the rest response
     */
    @ExceptionHandler(PermissionException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public RestResponse<String> handlePermissionException(Exception e) {
        return new RestResponse<>(HttpStatus.FORBIDDEN.value(), e.getMessage(), "");
    }

    /**
     * Handle json processing exception rest response.
     *
     * @param e the e
     * @return the rest response
     */
    @ExceptionHandler(JsonProcessingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse<String> handleJsonProcessingException(Exception e) {
        return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "");
    }

    /**
     * Handle not found exception rest response.
     *
     * @param e the e
     * @return the rest response
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public RestResponse<String> handleNotFoundException(Exception e) {
        return new RestResponse<>(HttpStatus.NOT_FOUND.value(), e.getMessage(), "");
    }

    /**
     * Handle method argument not valid exception rest response.
     *
     * @param e the e
     * @return the rest response
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse<String> handleMethodArgumentNotValidException(Exception e) {
        return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "");
    }

    /**
     * Handle method argument type mismatch exception exception rest response.
     *
     * @param e the e
     * @return the rest response
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse<String> handleMethodArgumentTypeMismatchExceptionException(Exception e) {
        return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "");
    }

    /**
     * Handle validate exception exception.
     *
     * @param e        the e
     * @param response the response
     * @param writer   the writer
     * @throws IOException the io exception
     */
    @ExceptionHandler(ValidateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public void handleValidateExceptionException(Exception e, HttpServletResponse response, Writer writer) throws IOException {
        response.addHeader("Content-Type", "application/json");
        writer.write(e.getMessage());
    }


    @ExceptionHandler(AuthorizationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public RestResponse<String> handleAuthorizationException(Exception e) {
        return new RestResponse<>(HttpStatus.UNAUTHORIZED.value(), e.getMessage(), "");
    }
}