package com.seater.community.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.seater.community.exception.ErrorResponse;
import com.seater.community.exception.badrequest.InvalidValueException;
import com.seater.community.exception.internal.InternalServerException;
import com.seater.community.exception.notfound.NotFoundException;
import com.seater.community.exception.unauthorized.UnAuthorizedException;

import static com.seater.community.exception.ErrorCode.UNEXPECTED_INTERNAL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionController {

    private static final String ERROR_LOG_FORMAT =
            "Error Class : {}, Error Code : {}, Message : {}";
    private final MessageSourceAccessor messageSourceAccessor;


    public GlobalExceptionController(MessageSource messageSource) {
        this.messageSourceAccessor = new MessageSourceAccessor(messageSource);
    }

    @ExceptionHandler(InvalidValueException.class)
    public ResponseEntity<ErrorResponse> handleInvalidValueException(
            final InvalidValueException e) {
        final int code = e.getErrorCode().getCode();
        final String message = messageSourceAccessor.getMessage(e.getMessage());

        log.info(ERROR_LOG_FORMAT, e.getClass().getSimpleName(), code, message);
        return ResponseEntity.ok().body(new ErrorResponse(code, message));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(final NotFoundException e) {
        final int code = e.getErrorCode().getCode();
        final String message = messageSourceAccessor.getMessage(e.getMessage());

        log.info(ERROR_LOG_FORMAT, e.getClass().getSimpleName(), code, message);
        return ResponseEntity.ok().body(new ErrorResponse(code, message));
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnAuthorizedException(
            final UnAuthorizedException e) {
        final int code = e.getErrorCode().getCode();
        final String message = messageSourceAccessor.getMessage(e.getMessage());

        log.info(ERROR_LOG_FORMAT, e.getClass().getSimpleName(), code, message);
        return ResponseEntity.ok().body(new ErrorResponse(code, message));
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ErrorResponse> handleInternalServerException(
            final InternalServerException e) {
        final int code = e.getErrorCode().getCode();
        final String message = messageSourceAccessor.getMessage(e.getMessage());

        log.warn(ERROR_LOG_FORMAT, e.getClass().getSimpleName(), code, message);
        return ResponseEntity.internalServerError().body(new ErrorResponse(code, message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedException(final Exception e) {
        final int code = UNEXPECTED_INTERNAL.getCode();
        final String message =
                messageSourceAccessor.getMessage(UNEXPECTED_INTERNAL.getMessageKey());

        log.error(ERROR_LOG_FORMAT, e.getClass().getName(), code, message);
        return ResponseEntity.internalServerError().body(new ErrorResponse(code, message));
    }
}
