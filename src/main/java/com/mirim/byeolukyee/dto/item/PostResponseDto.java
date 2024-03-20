package com.mirim.byeolukyee.dto.item;

import com.mirim.byeolukyee.dto.ResponseDto;
import com.mirim.byeolukyee.dto.user.UserResponseDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto extends ResponseDto {
    private final Long id;
    private final UserResponseDto user;
    private final String title;
    private final String description;
    private final Integer price;
    private final String location;


    public PostResponseDto(Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, Long id, UserResponseDto user, String title, String description, Integer price, String location) {
        super(isDeleted, createdAt, updatedAt);
        this.id = id;
        this.user = user;
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
    }
}
