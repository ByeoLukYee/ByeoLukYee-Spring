package com.mirim.byeolukyee.exception;

import com.mirim.byeolukyee.exception.error.ErrorCode;

public class PostNotFoundException extends GeneralException {
    public static final GeneralException EXCEPTION = new PostNotFoundException();
    private PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
