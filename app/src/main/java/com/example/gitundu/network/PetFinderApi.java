package com.example.gitundu.network;

import com.example.gitundu.models.PetFinderAnimalsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PetFinderApi {
    @GET("animals")
    Call<PetFinderAnimalsResponse> getPets(
            @Query("status") String finder
    );
}
