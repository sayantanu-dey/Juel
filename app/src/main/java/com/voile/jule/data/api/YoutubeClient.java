package com.voile.jule.data.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class YoutubeClient {
    private static String API_KEY = "AIzaSyBqr0F7dMAbZ3W5NdMNfuxmyDosnOmPPnU";
    private static String BASE_URL = "https://www.googleapis.com/youtube/v3/";
    private static Interceptor youtubeInterceptor;
    private static OkHttpClient okHttpClient;
    private static YoutubeClient instance = null;
    private static Object YoutubeInterface;

    private YoutubeClient(){
        youtubeInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return getResponse(chain);
            }
        };

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(youtubeInterceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

    }

    public static YoutubeInterface getInstance(){
        if(instance==null) instance = new YoutubeClient();
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(YoutubeInterface.class);
    }

    private Response getResponse(Interceptor.Chain chain) throws IOException {
        HttpUrl url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("key",API_KEY)
                .build();
        Request request = chain.request()
                .newBuilder()
                .url(url)
                .build();
        return chain.proceed(request);
    }
}
