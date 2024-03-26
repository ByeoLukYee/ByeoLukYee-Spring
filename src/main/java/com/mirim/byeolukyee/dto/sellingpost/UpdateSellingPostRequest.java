package com.mirim.byeolukyee.dto.sellingpost;

import com.mirim.byeolukyee.constant.SellingPostStatus;
import com.mirim.byeolukyee.dto.post.UpdatePostRequesetDto;
import lombok.Getter;

@Getter
public class UpdateSellingPostRequest extends UpdatePostRequesetDto {
    private SellingPostStatus status;
}
