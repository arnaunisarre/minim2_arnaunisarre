package com.example.arnau.minim2_arnaunisarre;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {

   // @GET ("/users/{user}")
    //Call<User> getUser(@Path("user") String user);

    @GET("/books")
    Call<List<Books>> getBooks();

    @GET ("/books/{id}")
    Call<Books> getId(@Path("id") String id);

}
