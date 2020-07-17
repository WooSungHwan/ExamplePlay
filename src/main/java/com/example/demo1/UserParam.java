package com.example.demo1;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserParam {
    @NotEmpty(message = "이메일을 입력해시기 바ㅂ니다.")
    @Email
    private String email;
}
