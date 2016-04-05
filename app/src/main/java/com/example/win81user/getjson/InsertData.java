package com.example.win81user.getjson;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertData extends Activity implements View.OnClickListener {
    public EditText etName,etUsername,etPasswd,phet,emet;
    public Button btAdd,registerBtn,Btnb;
    //เรียกใช้คลาส DBAdpter สำหรับการใช้งาน sqlite
    DBAdapter dbAdapter = new DBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        etName = (EditText) findViewById(R.id.name);
        etUsername = (EditText) findViewById(R.id.userET);
        etPasswd = (EditText) findViewById(R.id.passET);
        phet = (EditText) findViewById(R.id.phet);
        emet = (EditText) findViewById(R.id.emet);
        btAdd = (Button) findViewById(R.id.ok);
        Btnb = (Button) findViewById(R.id.Btnb);
        btAdd.setOnClickListener(this);
        Btnb.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok :
                try {
                    //เมื่อกดปุ่ม ok จำทำการเพิ่มข้อมูล
                    dbAdapter.openToWrite();
                    long status = dbAdapter.insert(etName.getText().toString(),etUsername.getText().toString(), etPasswd.getText().toString(),
                            phet.getText().toString(),emet.getText().toString());
                    dbAdapter.close();

                    Toast.makeText(this,"Register Sucess"+status,Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this,Login.class);
                    startActivity(i);
                }catch(Exception ex){
                    Toast.makeText(this,ex.toString(),Toast.LENGTH_LONG).show();
                }
            case R.id.Btnb:
                try {
                    Intent i = new Intent(this,Login.class);
                    startActivity(i);
                }
                catch (Exception ex){

                }
                break;


        }
    }
}