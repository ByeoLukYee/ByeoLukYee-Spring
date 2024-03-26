package com.mirim.byeolukyee.dto.buyingpost;

import com.mirim.byeolukyee.constant.BuyingPostStatus;
import com.mirim.byeolukyee.dto.post.UpdatePostRequesetDto;
import lombok.Getter;

@Getter
public class UpdateBuyingPostRequestDto extends UpdatePostRequesetDto {
    private BuyingPostStatus status;
}
