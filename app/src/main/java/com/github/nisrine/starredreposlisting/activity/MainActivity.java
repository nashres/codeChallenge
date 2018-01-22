package com.github.nisrine.starredreposlisting.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.nisrine.starredreposlisting.R;
import com.github.nisrine.starredreposlisting.adapter.RepositoriesAdapter;
import com.github.nisrine.starredreposlisting.api.RepositoryApiMaker;
import com.github.nisrine.starredreposlisting.api.RepositoryApiService;
import com.github.nisrine.starredreposlisting.model.RepositoryResponse;
import com.github.nisrine.starredreposlisting.utils.APIError;
import com.github.nisrine.starredreposlisting.utils.ErrorUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView = null;
    private CoordinatorLayout coordinatorLayout;
    public  RepositoriesAdapter adapter;
    RepositoryResponse repositoriesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = findViewById(R.id.container);
        recyclerView = findViewById(R.id.linear_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration); // Add divider between items

        //checking for network connectivity
        if (!isNetworkAvailable()) {
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "No Network connection", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            fetchFirstPage();
                        }
                    });

            snackbar.show();
        } else {
            fetchFirstPage();
        }

    }

    private void prepareData(RepositoryResponse repositoriesList) {
        adapter = new RepositoriesAdapter(repositoriesList.getItems());
        recyclerView.setAdapter(adapter);
    }

    private void fetchFirstPage() {
        Map<String, String> data = new HashMap<>();
        data.put("q", "created:>2017-10-22");
        data.put("sort", "stars");
        data.put("order", "desc");
        RepositoryApiService apiService = new RepositoryApiMaker().getService();
        Call<RepositoryResponse>  repositoryListCall= apiService.getRepositoryList(data);
        repositoryListCall.enqueue(new Callback<RepositoryResponse>() {
            @Override
            public void onResponse(Call<RepositoryResponse> call, Response<RepositoryResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this,
                            " Sucessful",
                            Toast.LENGTH_SHORT).show();
                    repositoriesList = response.body();
                    prepareData(repositoriesList); // add response to recyclerview

                } else {

                    APIError error = ErrorUtils.parseError(response);
                    Log.d("error message", error.message());
                }
            }

            @Override
            public void onFailure(Call<RepositoryResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "Request failed. Check your internet connection",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }



    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public void onResume() {
        super.onResume();
        recyclerView.setAdapter(adapter);
    }



}