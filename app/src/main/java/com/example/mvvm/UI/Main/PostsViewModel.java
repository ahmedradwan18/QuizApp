package com.example.mvvm.UI.Main;

import com.example.mvvm.Data.PostsClient;
import com.example.mvvm.Pojo.PostModel;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsViewModel extends ViewModel {
    MutableLiveData<List<PostModel>>postMutableLiveData=new MutableLiveData<>();

    // function to get data from retrofit
    public void getPosts() {

        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });

    }
}
