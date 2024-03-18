package com.mirim.byeolukyee.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequestDto {
    @NotBlank(message = "이름은 공백일 수 없습니다.")
    private String name;

    @Email
    @NotBlank(message = "이메일은 공백일 수 없습니다.")
    private String email;

    @NotBlank(message = "비밀번호는 공백일 수 없습니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{8,20}", message = "비밀번호는 8~20자 이내로 영문과 숫자로 이루어져야 합니다.")
    private String password;

    @NotBlank(message = "학번은 공백일 수 없습니다.")
    private String studentId;
    
}

