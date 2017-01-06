package com.rakaadinugroho.blogspotmobile.utils;

import com.rakaadinugroho.blogspotmobile.objects.Posts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Raka Adi Nugroho on 1/6/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public interface RestAPI {
    @GET("blogger/v3/blogs/{idblog}/posts")
    Call<Posts> getPosts(@Path("idblog") String idblog);
}
