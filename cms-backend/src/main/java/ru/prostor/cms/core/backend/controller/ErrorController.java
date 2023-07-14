package ru.prostor.cms.core.backend.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.prostor.cms.core.backend.exception.entity.AttributeNotFoundException;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(AttributeNotFoundException.class)
    public String catchAttributeNotFoundException(AttributeNotFoundException attributeNotFoundException) {
        return null; //TODO need to add 404 page and logger
    }
}
