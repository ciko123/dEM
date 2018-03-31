package com.ciko.guo.http.core;

import com.ciko.guo.bean.HttpResultCode;
import com.ciko.guo.bean.HttpResultError;
import com.ciko.guo.http.business.config.ApiException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * 创建时间: 2018/3/30 下午11:35
 * 类描述:
 *
 * @author Ciko
 */
final class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        HttpResultCode httpResultCode = gson.fromJson(response, HttpResultCode.class);
        if (httpResultCode.getResultCode() != 1000) {
            HttpResultError httpResultError = gson.fromJson(response, HttpResultError.class);
            value.close();
            throw new ApiException( httpResultError.getReturnObject());
        }

        MediaType contentType = value.contentType();
        Charset charset = contentType != null ? contentType.charset(UTF_8) : UTF_8;
        InputStream inputStream = new ByteArrayInputStream(response.getBytes());
        Reader reader = new InputStreamReader(inputStream, charset);
        JsonReader jsonReader = gson.newJsonReader(reader);

        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }

    }
}

