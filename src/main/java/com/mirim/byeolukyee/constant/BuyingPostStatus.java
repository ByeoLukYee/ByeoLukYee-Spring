package com.mirim.byeolukyee.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BuyingPostStatus {
    IN_PROGRESS("경매중"),
    COMPLETE("경매완료");

    private String krName;
}
