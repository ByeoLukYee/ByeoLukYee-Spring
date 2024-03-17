package com.mirim.byeolukyee.exception;


import com.mirim.byeolukyee.exception.error.ErrorCode;

public class UserNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserNotFoundException();
    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
