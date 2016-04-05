package com.example.win81user.getjson;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import android.content.Intent;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import butterknife.ButterKnife;
import butterknife.Bind;


public class AddBook extends AppCompatActivity {

    @Bind(R.id.editTextName) EditText editTextName;
    @Bind(R.id.editTextUsername) EditText editTextUsername;
    @Bind(R.id.editTextEmail) EditText editTextEmail;
    @Bind(R.id.editTextPassword) EditText editTextPassword;
    @Bind(R.id.buttonRegister) Button buttonRegister;
    @OnClick(R.id.buttonRegister) void insertdata(){
        insertUser();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);


    }

    public static final String ROOT_URL = "http://192.168.56.1:8181";

    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbook);


        Log.d("MainActivity", "onCreate");
        ButterKnife.bind(this);//ต้องมีทุกครั้ง

        Log.d("MainActivity","buttonRegister");

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void insertUser() {


        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();


        InsertBook addBook = adapter.create(InsertBook.class);


      addBook.insertBook(


              editTextName.getText().toString(),
              editTextUsername.getText().toString(),
              editTextPassword.getText().toString(),
              editTextEmail.getText().toString(),


              new Callback<Response>() {
                  @Override
                  public void success(Response result, Response response) {

                      BufferedReader reader = null;


                      String output = "";

                      try {

                          reader = new BufferedReader(new InputStreamReader(result.getBody().in()));


                          output = reader.readLine();
                          Log.d("resultASync", result + "");
                      } catch (IOException e) {
                          e.printStackTrace();
                      }


                      Toast.makeText(AddBook.this, output, Toast.LENGTH_LONG).show();


                  }

                  @Override
                  public void failure(RetrofitError error) {

                      Toast.makeText(AddBook.this, error.toString(), Toast.LENGTH_LONG).show();


                  }
              }
      );

    }




}
