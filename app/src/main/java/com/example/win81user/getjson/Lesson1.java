package com.example.win81user.getjson;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import  android.app.Activity;
import android.widget.ImageView;
import  android.widget.Button;
import android.media.MediaPlayer;


public class Lesson1 extends Activity implements View.OnClickListener{
    private final ImageView imAnimals[]=new ImageView[9];
    MediaPlayer mediaPlayer;
    Button btnback;
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animalview);
        imAnimals[0]=(ImageView) findViewById(R.id.imgcat);
        imAnimals[1]=(ImageView) findViewById(R.id.imgbird);
        imAnimals[2]=(ImageView) findViewById(R.id.imgcow);
        imAnimals[3]=(ImageView) findViewById(R.id.imgdog);
        imAnimals[4]=(ImageView) findViewById(R.id.imgduck);
        imAnimals[5]=(ImageView) findViewById(R.id.imgelephant);
        imAnimals[6]=(ImageView) findViewById(R.id.imgrooster);
        imAnimals[7]=(ImageView) findViewById(R.id.imghorse);
        imAnimals[8]=(ImageView) findViewById(R.id.imgpig);
        //set Listener to ImageView
        for (int i=0 ;i<imAnimals.length;i++) {
            imAnimals[i].setOnClickListener(this);

        }
    }
    //implement abstract method onClick(View)
    private void playSound(int soundid){
        if(mediaPlayer !=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        mediaPlayer=MediaPlayer.create(this,soundid);
        mediaPlayer.start();
    }


    @Override
    public void onClick(View view) {
        //ตรวจสอบว่าแตะที่รูปใดก็แสดงเสียงรูปนั้น
        int soundId=0;
        switch(view.getId()){
            case R.id.imgcat: soundId=R.raw.cat;
                playSound(soundId);
                break;
            case R.id.imgdog: soundId=R.raw.dog;
                playSound(soundId);
                break;
            case R.id.imgduck: soundId=R.raw.duck;
                playSound(soundId);
                break;
            case R.id.imgelephant: soundId=R.raw.elephant;
                playSound(soundId);
                break;
            case R.id.imgbird: soundId=R.raw.bird;
                playSound(soundId);
                break;
            case R.id.imghorse: soundId=R.raw.horse;
                playSound(soundId);
                break;
            case R.id.imgcow: soundId=R.raw.cow;
                playSound(soundId);
                break;
            case R.id.imgrooster: soundId=R.raw.rooster;
                playSound(soundId);
                break;
            case R.id.imgpig: soundId=R.raw.pig;
                playSound(soundId);
                break;
        }
    }
}
