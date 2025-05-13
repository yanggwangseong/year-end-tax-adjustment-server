package com.seater.community.exception.badrequest;

import static com.seater.community.exception.ErrorCode.INVALID_SMS_CREDENTIAL;

import com.seater.community.exception.ErrorCode;

/**
 * SMS 문자 인증 실패시 발생
 */
public class InvalidSmsCredentialException extends InvalidValueException {

    public InvalidSmsCredentialException() {
        super(INVALID_SMS_CREDENTIAL);
    }

    public InvalidSmsCredentialException(ErrorCode errorCode) {
        super(errorCode);
    }
}
