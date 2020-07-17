package com.example.demo1;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.validation.constraints.NotEmpty;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserParam {
    @NotEmpty(message = "이메일을 입력해시기 바ㅂ니다.")
    @Email
    private String email;

    private String url = "http://www.naver.com";
    private URI path = linkTo(UserController.class).toUri();
}
