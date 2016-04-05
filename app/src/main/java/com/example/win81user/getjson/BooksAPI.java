package com.example.win81user.getjson;

/**
 * Created by Win81 User on 29/3/2559.
 */
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Belal on 11/3/2015.
 */
public interface BooksAPI {

    /*Retrofit get annotation with our URL
       And our method that will return us the list ob Book
    */
    @GET("/RetrofitExample/show.php")
    public void getBooks(Callback<List<Book>> response);
}