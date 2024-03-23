package com.wqa.exam.configuration.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestReturn {
    private static final String SUCCESS = "Operacion exitosa";

    public static <T> ResponseEntity<RestReturnEntity<T>> ok() {
        return ResponseEntity.ok(RestReturnEntity.<T>builder().msg(SUCCESS).code("00").build());
    }

    public static <T> ResponseEntity<RestReturnEntity<T>> ok(String message) {
        return ResponseEntity.ok(RestReturnEntity.<T>builder().msg(message).code("00").build());
    }

    public static <T> ResponseEntity<RestReturnEntity<T>> ok(T data) {
        return ResponseEntity.ok(RestReturnEntity.<T>builder().msg(SUCCESS).code("00").data(data).build());
    }

    public static <T> ResponseEntity<RestReturnEntity<T>> ok(String message, T data) {
        return ResponseEntity.ok(RestReturnEntity.<T>builder().msg(message).code("00").data(data).build());
    }

    public static <T> ResponseEntity<RestReturnEntity<T>> fail(String message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(RestReturnEntity.<T>builder().msg(message).code("05").build());
    }

}
