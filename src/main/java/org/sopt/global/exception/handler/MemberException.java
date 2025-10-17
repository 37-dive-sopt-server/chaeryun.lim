package org.sopt.global.exception.handler;

import org.sopt.global.exception.CustomException;
import org.sopt.global.exception.ErrorCode;

public class MemberException extends CustomException {
    public MemberException(ErrorCode errorCode) {
        super(errorCode);
    }
}
