package com.mirim.byeolukyee.dto.user;

import com.mirim.byeolukyee.dto.ResponseDto;
import com.mirim.byeolukyee.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto extends ResponseDto {
    private final Long id;
    private final String name;
    private final String email;
    private final String password;
    private final String studentId;

    @Builder
    public UserResponseDto(Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, Long id, String name, String email, String password, String studentId) {
        super(isDeleted, createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.studentId = studentId;
    }

    public static UserResponseDto from(User user) {
        return UserResponseDto.builder()
                .isDeleted(user.getIsDeleted())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .studentId(user.getStudentId())
                .build();
    }
}
