package com.example.student.work6_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.student.work6_10.Api.LazyInstragramApi;
import com.example.student.work6_10.adapter.PostAdapter;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.student.work6_10.R.id.imageProfile;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUserProfile("cartoon");

        PostAdapter postAdapter = new PostAdapter(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(postAdapter);


    }

    private void getUserProfile(String userName) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(LazyInstragramApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LazyInstragramApi lazyInstragramApi =
                retrofit.create(LazyInstragramApi.class);

        Call<UserProfile>  call = lazyInstragramApi.getProfile(userName);
        call.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                if (response.isSuccessful()){
                    UserProfile userProfile = response.body(); //ได้ผลลัพท์ result กลับมา >> เอาไปแสดงไหนดี
                    TextView textUser = (TextView) findViewById(R.id.textUser);
                    textUser.setText("@"+ userProfile.getUser());

                    ImageView imageUser = (ImageView) findViewById(imageProfile);
                    Glide.with(MainActivity.this).load(userProfile.getUrlProfile()).into(imageUser);

                }
            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {

            }
        });

        /*
        Call<String> call = lazyInstragramApi.getProfile(userName);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()){
                    String result = response.body(); //ได้ผลลัพท์ result กลับมา >> เอาไปแสดงไหนดี
                    TextView textUser = (TextView) findViewById(R.id.textUser);
                    textUser.setText(result);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }

        });
        */
    }
}
