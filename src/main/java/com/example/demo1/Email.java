package com.example.demo1;

import org.springframework.util.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.regex.Pattern;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

@Constraint(validatedBy = Email.EmailValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
public @interface Email {

    String message() default "이메일이 양식에 맞지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};

    class EmailValidator implements ConstraintValidator<Email, String> {
        private final String REGEX_EMAIL = "[a-z0-9][a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])";
        public Pattern email = Pattern.compile(REGEX_EMAIL);

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            System.out.println("email validation");
            if(StringUtils.isEmpty(s)) {
                return true;
            } else {
                return email.matcher(s).matches();
            }
        }
    }

}
