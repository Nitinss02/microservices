package com.microservices.rating.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalResourceNotFound {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Map<String, Object>> notFoundException(ResourceNotFound ex) {
        Map map = new HashMap();
        map.put("message", ex.getMessage());
        map.put("status", HttpStatus.NOT_FOUND);
        map.put("sucess", false);
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
