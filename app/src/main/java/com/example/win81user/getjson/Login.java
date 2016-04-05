package com.example.win81user.getjson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends Activity  {
    public EditText etUsername,etPasswd;
    //public Button loginBtn,registerBtn;
    //เรียกใช้คลาส DBAdpter สำหรับการใช้งาน sqlite
    DBAdapter dbAdapter = new DBAdapter(this);
    @Bind(R.id.login1) Button btnlogin;
    @Bind(R.id.registerBtn) Button btnregis;
    @OnClick(R.id.registerBtn) void regis(){
        Intent i = new Intent(this,InsertData.class);
        startActivity(i);
    }

    @OnClick(R.id.login1) void check(){
        try {
            //เมื่อกดปุ่ม ok จำทำการเพิ่มข้อมูล
            dbAdapter.openToWrite();
            boolean status = dbAdapter.select(etUsername.getText().toString(), etPasswd.getText().toString());
            dbAdapter.close();

            if(status == true){
                Toast.makeText(this,"Welcome",Toast.LENGTH_LONG).show();
                Intent i = new Intent(this,Select.class);
                startActivity(i);
            } else {
                Toast.makeText(this,"Invalid Username or Password",Toast.LENGTH_LONG).show();
            }
        }catch(Exception ex){
            Toast.makeText(this,ex.toString(),Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        etUsername = (EditText) findViewById(R.id.userET);
        etPasswd = (EditText) findViewById(R.id.passET);
       // loginBtn = (Button) findViewById(R.id.login);
        //registerBtn=(Button)findViewById(R.id.registerBtn);
        //loginBtn.setOnClickListener(this);
        //registerBtn.setOnClickListener(this);
        ButterKnife.bind(this);
    }


}
