package com.mirim.byeolukyee.exception;

import com.mirim.byeolukyee.exception.error.ErrorCode;

public class DuplicateEmailException extends BusinessException {
    public static BusinessException EXCEPTION = new DuplicateEmailException();

    private DuplicateEmailException() {
        super(ErrorCode.DUPLICATE_EMAIL);
    }
}
