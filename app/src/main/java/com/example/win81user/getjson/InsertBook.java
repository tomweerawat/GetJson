package com.example.win81user.getjson;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;



public interface InsertBook {
    @FormUrlEncoded
    @POST("/RetrofitExample/insert.php")//ใช้ส่ง
    public void insertBook(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            Callback<Response> callback);

    //@GET("/android/show.json")//ใช้ดึง
    // public void select(Callback<List<Response>> response);
}