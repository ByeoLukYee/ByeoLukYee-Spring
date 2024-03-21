package com.mirim.byeolukyee.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddPostRequestDto {
    @NotBlank(message = "유저 아이디는 공백일 수 없습니다.")
    private Long userId;

    @NotBlank(message = "제목은 공백일 수 없습니다.")
    private String title;

    @NotBlank(message = "설명은 공백일 수 없습니다.")
    private String description;

    @NotBlank(message = "가격은 공백일 수 없습니다.")
    private Integer price;

    @NotBlank(message = "거래 희망 장소는 공백일 수 없습니다.")
    private String location;
}
