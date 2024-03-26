package com.mirim.byeolukyee.dto.buyingpost;

import com.mirim.byeolukyee.constant.SellingPostStatus;
import com.mirim.byeolukyee.dto.post.UpdatePostRequesetDto;
import lombok.Getter;

@Getter
public class UpdateBuyingPostRequestDto extends UpdatePostRequesetDto {
    private SellingPostStatus status;
}
