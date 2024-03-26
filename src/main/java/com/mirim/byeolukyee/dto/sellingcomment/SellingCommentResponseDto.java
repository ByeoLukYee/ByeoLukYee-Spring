package com.mirim.byeolukyee.dto.sellingcomment;

import com.mirim.byeolukyee.constant.SellingCommentStatus;
import com.mirim.byeolukyee.dto.post.PostResponseDto;
import com.mirim.byeolukyee.dto.user.UserResponseDto;
import com.mirim.byeolukyee.entity.SellingComment;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SellingCommentResponseDto extends PostResponseDto {
    private final SellingCommentStatus status;
    private final String krStatus;

    @Builder
    public SellingCommentResponseDto(Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, Long id, UserResponseDto user, String title, String description, Integer price, String location, SellingCommentStatus status) {
        super(isDeleted, createdAt, updatedAt, id, user, title, description, price, location);
        this.status = status;
        this.krStatus = status.getKrName();
    }

    public static SellingCommentResponseDto from(SellingComment sellingComment) {
        return SellingCommentResponseDto.builder()
                .isDeleted(sellingComment.getIsDeleted())
                .createdAt(sellingComment.getCreatedAt())
                .updatedAt(sellingComment.getUpdatedAt())
                .id(sellingComment.getId())
                .user(UserResponseDto.from(sellingComment.getUser()))
                .title(sellingComment.getTitle())
                .description(sellingComment.getDescription())
                .price(sellingComment.getPrice())
                .location(sellingComment.getLocation())
                .status(sellingComment.getStatus())
                .build();
    }
}
