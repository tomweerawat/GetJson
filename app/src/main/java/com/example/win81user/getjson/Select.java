package com.example.win81user.getjson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Select extends Activity {
    @Bind(R.id.btnadd) Button btnadd;
    @Bind(R.id.btnsb) Button btnsb;
    @Bind(R.id.btnasy) Button btnasync;
    @Bind(R.id.btnlesson) Button btnless;
    @Bind(R.id.button2) Button button2;
            @OnClick(R.id.btnadd) void add(){
                Intent i = new Intent(this,AddBook.class);
                startActivity(i);

            }
    @OnClick(R.id.btnsb) void add1(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }

    @OnClick(R.id.btnasy) void add2(){
        Intent i = new Intent(this,ShowPic.class);
        startActivity(i);

    }
    @OnClick(R.id.btnlesson) void add3(){
        Intent i = new Intent(this,Lesson1.class);
        startActivity(i);

    }
    @OnClick(R.id.button2) void add4(){
        Intent i = new Intent(this,Login.class);
        startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);
        ButterKnife.bind(this);

    }

}
