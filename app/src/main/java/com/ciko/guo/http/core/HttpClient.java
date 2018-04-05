package com.ciko.guo.http.core;

import com.ciko.guo.BuildConfig;
import com.ciko.guo.UserCache;
import com.ciko.guo.http.business.config.Url;
import com.google.gson.Gson;
import com.google.gson.internal.bind.ArrayTypeAdapter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建时间: 2018/3/29 下午2:30
 * 类描述:
 *
 * @author Ciko
 */
public class HttpClient {

    private final int DEFAULT_TIMEOUT = 5;

    private static HttpClient httpClient;

    private Retrofit retrofit;

    private HttpClient() {

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(httpLoggingInterceptor);
        }

        /**
         *  拦截器
         */
        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                HttpUrl.Builder authorizedUrlBuilder = request.url()
                        .newBuilder()
                        //添加统一参数 如手机唯一标识符,token等
                        .addQueryParameter("accountType", "android")
                        .addQueryParameter("clientType", BuildConfig.VERSION_NAME)
                        .addQueryParameter("timeStamp", System.currentTimeMillis() + "");

                if (UserCache.getIns().getUser() != null) {
                    authorizedUrlBuilder.addQueryParameter("account", UserCache.getIns().getAccount());
                    authorizedUrlBuilder.addQueryParameter("password", UserCache.getIns().getPsw());
                }

                Request newRequest = request.newBuilder()
                        //对所有请求添加请求头
//                        .header("mobileFlag", "adfsaeefe").addHeader("type", "4")
                        .method(request.method(), request.body())
                        .url(authorizedUrlBuilder.build())
                        .build();

                return  chain.proceed(newRequest);
            }
        });

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(CustomGsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Url.BASE_URL)
                .build();

    }

    public static HttpClient getIns() {
        if (httpClient == null) {
            synchronized (HttpClient.class) {
                if (httpClient == null) {
                    httpClient = new HttpClient();
                }
            }
        }
        return httpClient;
    }

    public <T> T service(Class<T> cls) {
        return retrofit.create(cls);
    }


}
