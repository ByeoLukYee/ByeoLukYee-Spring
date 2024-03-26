package com.mirim.byeolukyee.dto.sellingpost;

import com.mirim.byeolukyee.constant.SellingPostStatus;
import lombok.Getter;

@Getter
public class UpdateSellingPostRequest {
    private String title;
    private String description;
    private Integer price;
    private String location;
    private SellingPostStatus status;
}
