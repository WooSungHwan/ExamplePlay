package com.example.demo1;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/user", produces = MediaTypes.HAL_JSON_VALUE)
public class UserController {

    @PostMapping
    public ResponseEntity addUser(@RequestBody @Valid UserParam userParam, Errors errors) throws Exception {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }
        System.out.println(userParam);
        return new ResponseEntity(userParam, HttpStatus.OK);
    }

}
