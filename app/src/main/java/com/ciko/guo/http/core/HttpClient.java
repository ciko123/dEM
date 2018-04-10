package com.ciko.guo.http.core;

import com.ciko.guo.BuildConfig;
import com.ciko.guo.UserCache;
import com.ciko.guo.http.business.config.Url;
import com.ciko.guo.utils.EmptyUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

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

                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder();

                FormBody.Builder newFormBody = new FormBody.Builder();
                RequestBody requestBody = original.body();
                if (requestBody instanceof FormBody) {
                    FormBody oidFormBody = (FormBody) original.body();
                    if (EmptyUtil.isNotEmpty(oidFormBody)) {
                        for (int i = 0; i < oidFormBody.size(); i++) {
                            newFormBody.addEncoded(oidFormBody.encodedName(i), oidFormBody.encodedValue(i));
                        }
                    }
                }

                newFormBody.add("accountType", "android");
                newFormBody.add("clientType", BuildConfig.VERSION_NAME);
                newFormBody.add("timeStamp", System.currentTimeMillis() + "");


                if (UserCache.getIns().getUser() != null) {
                    newFormBody.add("account", UserCache.getIns().getAccount());
                }

                requestBuilder.method(original.method(), newFormBody.build());

                Request request = requestBuilder.build();
                return chain.proceed(request);
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
