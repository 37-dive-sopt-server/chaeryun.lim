package org.sopt.global.exception.handler;

import org.sopt.global.exception.CustomException;
import org.sopt.global.exception.ErrorCode;

public class ArticleException extends CustomException {
    public ArticleException(ErrorCode errorCode) {
        super(errorCode);
    }
}
