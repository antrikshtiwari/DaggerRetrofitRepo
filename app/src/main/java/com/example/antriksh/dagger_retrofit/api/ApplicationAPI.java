package com.example.antriksh.dagger_retrofit.api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by antrikshtiwari on 11/04/16.
 */
public interface ApplicationAPI {

    /*
    * Get request with query and path params
    * */
    @GET("/startOfUrl/{pathParam}/lists")
    Call<ArrayList<YourApi>> dummyGetRequest(@Path("pathParam") String pathParam,
                                                @Query("queryParam") String queryParam);
    /*
     * Put request with query and path params
     * */
    @PUT("/startOfUrl/{pathParam}/lists")
    Call<YourApi> dummyPutRequest(@Path("pathParam") String pathParam,
                        @Query("queryParam") String queryParam);

    /*
     * Post request passing request body
     * */
    @POST("/startOfUrl")
    Call<Object> dummyPostRequest(@Body PostRequestApi device);
}
