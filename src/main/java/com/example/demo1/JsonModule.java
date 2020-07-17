package com.example.demo1;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.validation.Errors;

public class JsonModule extends SimpleModule {
    public JsonModule() {
        addSerializer(Errors.class, new ErrorsSerializer());
    }
}
