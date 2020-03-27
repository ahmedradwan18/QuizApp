package com.example.mvvm.Data;

import com.example.mvvm.Pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public Call<List<PostModel>>getPosts();
}
