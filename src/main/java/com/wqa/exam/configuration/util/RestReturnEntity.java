package com.wqa.exam.configuration.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestReturnEntity<T> {
    private String msg;
    private String code;
    private T data;

}
