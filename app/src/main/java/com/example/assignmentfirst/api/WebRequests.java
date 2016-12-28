package com.example.assignmentfirst.api;

import com.example.assignmentfirst.extras.Constants;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Inspiron on 12/27/2016.
 */

public interface WebRequests {



    @GET(Constants.API+Constants.ALL_STORES)
    Call<JsonObject> list_of_all_stores(@Query(Constants.MembershipProgramId) int MembershipProgramId);



}