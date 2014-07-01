package com.example.timertask2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {
 
 CheckBox optSingleShot;
 Button btnStart, btnCancel;
 TextView textCounter;
 
 Timer timer;
 MyTimerTask myTimerTask;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  optSingleShot = (CheckBox)findViewById(R.id.singleshot);
  btnStart = (Button)findViewById(R.id.start);
  btnCancel = (Button)findViewById(R.id.cancel);
  textCounter = (TextView)findViewById(R.id.counter);
  
  btnStart.setOnClickListener(new OnClickListener(){

   @Override
   public void onClick(View arg0) {

    if(timer != null){
     timer.cancel();
    }
    
    //re-schedule timer here
    //otherwise, IllegalStateException of
    //"TimerTask is scheduled already" 
    //will be thrown
    timer = new Timer();
    myTimerTask = new MyTimerTask();
    
    if(optSingleShot.isChecked()){
     //singleshot delay 1000 ms
     timer.schedule(myTimerTask, 1000);
    }else{
     //delay 1000ms, repeat in 5000ms
     timer.schedule(myTimerTask, 1000, 5000);
    }
   }});
  
  btnCancel.setOnClickListener(new OnClickListener(){

   @Override
   public void onClick(View v) {
    if (timer!=null){
     timer.cancel();
     timer = null;
    }
   }
  });
  
 }

 class MyTimerTask extends TimerTask {

  @Override
  public void run() {
   Calendar calendar = Calendar.getInstance();
   SimpleDateFormat simpleDateFormat = 
     new SimpleDateFormat("dd:MMMM:yyyy HH:mm:ss a");
   final String strDate = simpleDateFormat.format(calendar.getTime());
   
   runOnUiThread(new Runnable(){

    @Override
    public void run() {
     textCounter.setText(strDate);
    }});
  }
  
 }

}