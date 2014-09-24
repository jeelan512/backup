package com.example.seekbarwidget;


import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SeekbarActivity extends Activity { 
	TextView textview; 
	SeekBar seekbar;
	private AudioManager audioManager = null; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar); 
       
        textview = (TextView)findViewById(R.id.textView);
        seekbar = (SeekBar)findViewById(R.id.seekBar1);
        initControls();
        
        seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { 
	          //add here your implementation 
            } 
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { 
              //add here your implementation
            } 
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                boolean fromUser) { 
            	audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                        progress, 0); 
            	textview.setText("Media Volume value = " + progress);
            }
          });
    }
    private void initControls()
    {
        try
        {
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            seekbar.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            seekbar.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));   
 
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
     @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
        case KeyEvent.KEYCODE_VOLUME_UP:
            audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
            //Raise the Volume Bar on the Screen
            seekbar.setProgress( audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
                    );
            return true;
        case KeyEvent.KEYCODE_VOLUME_DOWN:
            //Adjust the Volume
            audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
            //Lower the VOlume Bar on the Screen
            seekbar.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC)
                    );
            return true;
        default:
            return false;
        }
    }
}
