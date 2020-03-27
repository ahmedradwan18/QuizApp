package com.example.mvvm.UI.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvm.Pojo.PostModel;
import com.example.mvvm.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostsViewModel postsViewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);
        postsViewModel.getPosts();
        recyclerView = findViewById(R.id.recycler);
        final PostsAdapter adapter=new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        postsViewModel.postMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });

    }
}
