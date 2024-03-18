package com.mirim.byeolukyee.exception;

import com.mirim.byeolukyee.exception.error.ErrorCode;

public class IncorrectPasswordException extends GeneralException {
    public static final GeneralException EXCEPTION = new IncorrectPasswordException();
    private IncorrectPasswordException() {
        super(ErrorCode.INCORRECT_PASSWORD);
    }
}
