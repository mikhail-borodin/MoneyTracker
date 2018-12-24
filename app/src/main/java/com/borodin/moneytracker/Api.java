package com.borodin.moneytracker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://moneytrackerborodin.getsandbox.com/";

    @GET("/items")
    Call<List<Item>> getItems(@Query("type") String type);
}
