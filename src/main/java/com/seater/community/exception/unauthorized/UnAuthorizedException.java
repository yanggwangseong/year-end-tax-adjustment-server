package com.seater.community.exception.unauthorized;

import com.seater.community.exception.CustomException;
import com.seater.community.exception.ErrorCode;

/*
 * 사용자 인증 관련 예외 JWT, 인증되지 않은 사용자가 리소스에 접근을 시도할 때 발생
 */
public class UnAuthorizedException extends CustomException {

    public UnAuthorizedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
