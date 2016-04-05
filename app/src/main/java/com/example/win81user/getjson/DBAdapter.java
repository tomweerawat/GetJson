package com.example.win81user.getjson;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {
    public static final String DBName = "member";
    public static final String TBName = "Users";
    public static final String ID = "id";
    public static final String Fld_name = "fullname";
    public static final String Fld_username = "username";
    public static final String Fld_passwd = "passwd";
    public static final String Fld_phone = "phone";
    public static final String Fld_email = "email";

    public static int DBVersion = 1; //เก็บเวอร์ชั่นของฐานข้อมูล
    public static final String SQL_stm= "create table "+TBName+"("+ID+" integer primary key,"+Fld_name+" text,"+Fld_username+" text,"+Fld_passwd+" text,"+Fld_phone+" text,"+Fld_email+")";
    //ประกาศตัวแปรออบเจ็คต์สำหรับบริหารจัดการฐานข้อมูล
    private SQLiteHelper sqlitehelper;
    private SQLiteDatabase sqlitedatabase;
    //context ใช้ในการเก็บค่าที่ใช้ในการสื่อสารภายในคลาสหรือแอพพลิเคชั่น
    private Context context;
    public DBAdapter(Context c){
        context = c;
    }
    //สร้างเมธอดสำหรับ manipulate data
    //เมธอดเปิดใช้งานแบบอ่านได้อย่างเดียว
    public DBAdapter openToRead() throws android.database.SQLException {
        sqlitehelper = new SQLiteHelper(context,TBName,null,DBVersion);
        sqlitedatabase = sqlitehelper.getReadableDatabase();
        return this;
    }
    //เมธอดเปิดใช้งานแบบอ่านและเขียนได้
    public DBAdapter openToWrite() throws android.database.SQLException{
        sqlitehelper = new SQLiteHelper(context,TBName,null,DBVersion);
        sqlitedatabase = sqlitehelper.getWritableDatabase();
        return this;
    }
    //เมธอดปิดการเชื่อมต่อฐานข้อมูล
    public void close(){
        sqlitehelper.close();
    }
    //เมธทดเพิ่มข้อมูลใหม่
    public long insert (String name,String username,String passwd, String phone,String email){
        //ส่งค่าไปเก็บในตารางผ่านคลาส contentValues โดยจะส่งไปเป้นคู่ (pairvalues)
        ContentValues contentValues = new ContentValues();
        contentValues.put(Fld_name,name);
        contentValues.put(Fld_username,username);
        contentValues.put(Fld_passwd, passwd);
        contentValues.put(Fld_phone, phone);
        contentValues.put(Fld_email, email);
        return sqlitedatabase.insert(TBName,null,contentValues);
    }

    public boolean select (String username,String passwd){
        //ส่งค่าไปเก็บในตารางผ่านคลาส contentValues โดยจะส่งไปเป้นคู่ (pairvalues)
        Cursor cursor = null;
        String Query = "SELECT * FROM "+TBName+" WHERE "+Fld_username+"='"+username+"' AND "+Fld_passwd+"='"+passwd+"'";
        cursor = sqlitedatabase.rawQuery(Query, null);
        if (cursor != null && cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }
    }

    //สร้างคลาส SQLiteHelper เพื่อทำการสร้างฐานข้อมูล
    public class SQLiteHelper extends SQLiteOpenHelper {

        public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //สั่งประมวลคำสั่ง sql สำหรับสร้างตารางฐานข้อมูล
            db.execSQL(SQL_stm);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
