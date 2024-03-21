package com.mirim.byeolukyee.dto.sellingpost;

import com.mirim.byeolukyee.constant.SellingPostStatus;
import com.mirim.byeolukyee.dto.post.PostResponseDto;
import com.mirim.byeolukyee.dto.user.UserResponseDto;
import com.mirim.byeolukyee.entity.SellingPost;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SellingPostResponseDto extends PostResponseDto {

    private final SellingPostStatus status;
    private final String krStatus;

    @Builder
    public SellingPostResponseDto(Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, Long id, UserResponseDto user, String title, String description, Integer price, String location, SellingPostStatus status) {
        super(isDeleted, createdAt, updatedAt, id, user, title, description, price, location);
        this.status = status;
        this.krStatus = status.getKrName();
    }

    public static SellingPostResponseDto from(SellingPost product) {
        return SellingPostResponseDto.builder()
                .isDeleted(product.getIsDeleted())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .id(product.getId())
                .user(UserResponseDto.from(product.getUser()))
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .location(product.getLocation())
                .status(product.getStatus())
                .build();
    }

}
