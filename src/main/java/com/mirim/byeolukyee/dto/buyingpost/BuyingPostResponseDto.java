package com.mirim.byeolukyee.dto.buyingpost;

import com.mirim.byeolukyee.constant.BuyingPostStatus;
import com.mirim.byeolukyee.constant.SellingPostStatus;
import com.mirim.byeolukyee.dto.post.PostResponseDto;
import com.mirim.byeolukyee.dto.user.UserResponseDto;
import com.mirim.byeolukyee.entity.BuyingPost;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BuyingPostResponseDto extends PostResponseDto {
    private final BuyingPostStatus status;
    private final String krStatus;

    @Builder
    public BuyingPostResponseDto(Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, Long id, UserResponseDto user, String title, String description, Integer price, String location, BuyingPostStatus status) {
        super(isDeleted, createdAt, updatedAt, id, user, title, description, price, location);
        this.status = status;
        this.krStatus = status.getKrName();
    }
    
    public static BuyingPostResponseDto from(BuyingPost buyingPost) {
        return BuyingPostResponseDto.builder()
                .isDeleted(buyingPost.getIsDeleted())
                .createdAt(buyingPost.getCreatedAt())
                .updatedAt(buyingPost.getUpdatedAt())
                .id(buyingPost.getId())
                .user(UserResponseDto.from(buyingPost.getUser()))
                .title(buyingPost.getTitle())
                .description(buyingPost.getDescription())
                .price(buyingPost.getPrice())
                .location(buyingPost.getLocation())
                .status(buyingPost.getStatus())
                .build();
    }
}
