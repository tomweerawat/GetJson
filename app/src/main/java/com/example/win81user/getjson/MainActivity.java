package com.example.win81user.getjson;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {


    public static final String ROOT_URL = "http://192.168.56.1:8181";

    public static final String KEY_BOOK_ID = "key_book_id";
    public static final String KEY_BOOK_NAME = "key_book_name";
    public static final String KEY_BOOK_PRICE = "key_book_price";
    public static final String KEY_BOOK_STOCK = "key_book_stock";


    private ListView listView;


    private List<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.listViewBooks);


        getBooks();


        listView.setOnItemClickListener(this);
    }

    private void getBooks(){

        final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please wait...",false,false);


        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();


        BooksAPI api = adapter.create(BooksAPI.class);


        api.getBooks(new Callback<List<Book>>() {
            @Override
            public void success(List<Book> list, Response response) {

                loading.dismiss();


                books = list;


                showList();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


    private void showList(){

        String[] items = new String[books.size()];


        for(int i=0; i<books.size(); i++){

            items[i] = books.get(i).getName();
        }


        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.simple_list,items);


        listView.setAdapter(adapter);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, ShowBookDetails.class);


        Book book = books.get(position);


        intent.putExtra(KEY_BOOK_ID,book.getBookId());
        intent.putExtra(KEY_BOOK_NAME,book.getName());
        intent.putExtra(KEY_BOOK_PRICE,book.getPrice());
        intent.putExtra(KEY_BOOK_STOCK,book.getInStock());
        startActivity(intent);
    }
}
