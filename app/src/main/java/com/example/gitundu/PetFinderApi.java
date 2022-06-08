package com.example.gitundu;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PetFinderApi {
    @GET("animals")
    Call<PetFinderAnimalsResponse> getPets(
            @Query("location") String finder
    );
}
