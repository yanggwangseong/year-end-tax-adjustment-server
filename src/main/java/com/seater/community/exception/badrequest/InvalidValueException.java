package com.seater.community.exception.badrequest;

import com.seater.community.exception.CustomException;
import com.seater.community.exception.ErrorCode;

/*
 * 잘못된 값을 입력 했을 때 발생
 */
public class InvalidValueException extends CustomException {
    public InvalidValueException(ErrorCode errorCode) {
        super(errorCode);
    }
}
