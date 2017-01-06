package com.rakaadinugroho.blogspotmobile.utils;

import com.rakaadinugroho.blogspotmobile.base.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Raka Adi Nugroho on 1/6/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class ApiService {
    private RestAPI restAPI;
    public ApiService(){
        Retrofit retrofit   = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(builder())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        restAPI = retrofit.create(RestAPI.class);
    }

    private OkHttpClient builder() {
        OkHttpClient.Builder builder    = new OkHttpClient().newBuilder();
        builder.connectTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.readTimeout(90, TimeUnit.SECONDS);

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url()
                        .newBuilder()
                        .addQueryParameter("key", Constants.BLOG_KEY)
                        .build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        });
        return builder.build();
    }
    public void getPostList(String blogid, Callback callback){
        restAPI.getPosts(blogid).enqueue(callback);
    }
}
