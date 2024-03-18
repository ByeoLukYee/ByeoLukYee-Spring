package com.mirim.byeolukyee.exception;

import com.mirim.byeolukyee.exception.error.ErrorCode;

public class DuplicateEmailException extends GeneralException {
    public static GeneralException EXCEPTION = new DuplicateEmailException();

    private DuplicateEmailException() {
        super(ErrorCode.DUPLICATE_EMAIL);
    }
}
