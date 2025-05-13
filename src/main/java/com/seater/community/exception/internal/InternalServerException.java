package com.seater.community.exception.internal;

import com.seater.community.exception.CustomException;
import com.seater.community.exception.ErrorCode;

/*
 * 서버 에러 예외 AWS component connection, DB connection..
 */
public class InternalServerException extends CustomException {

    public InternalServerException(ErrorCode errorCode) {
        super(errorCode);
    }
}
