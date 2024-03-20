package com.mirim.byeolukyee.dto.item;

import javax.validation.constraints.NotBlank;


public class AddPostRequest {
    private Long userId;

    @NotBlank(message = "제목은 공백일 수 없습니다.")
    private String title;
}
