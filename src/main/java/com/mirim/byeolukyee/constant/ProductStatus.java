package com.mirim.byeolukyee.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductStatus {
    IN_PROGRESS("판매중"),
    RESERVED("예약중"),
    COMPLETE("판매완료");

    private String krName;

}
