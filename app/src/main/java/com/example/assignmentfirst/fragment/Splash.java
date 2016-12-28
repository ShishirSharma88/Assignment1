package com.example.assignmentfirst.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignmentfirst.R;
import com.example.assignmentfirst.api.WebRequests;
import com.example.assignmentfirst.extras.Constants;
import com.example.assignmentfirst.extras.Keys;
import com.google.gson.JsonObject;

import org.json.JSONException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Inspiron on 12/27/2016.
 */

public class Splash extends Fragment implements Callback<JsonObject> {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.splash,container,false);
    }

    private void initialize(View view) {
        WebRequests service = initializeRetrofit().create(WebRequests.class);
        Call<JsonObject> call = service.list_of_all_stores(Constants.INT_ONE);
        call.enqueue(this);
    }

    private Retrofit initializeRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

            if (response.code() == Constants.SUCCESS) {
                response.body().toString();
                Fragment fragment = new Home();
                Bundle bundle = new Bundle();
                bundle.putString(Keys.StoreList,response.body().toString());
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,fragment,Constants.HomeFragment)
                        .commit();
            }

    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {

    }
}
