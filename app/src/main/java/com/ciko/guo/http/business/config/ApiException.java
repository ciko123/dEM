package com.ciko.guo.http.business.config;

public class ApiException extends RuntimeException {

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

}
