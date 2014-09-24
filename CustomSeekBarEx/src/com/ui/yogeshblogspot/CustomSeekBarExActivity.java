package com.ui.yogeshblogspot;
import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;
public class CustomSeekBarExActivity extends Activity implements OnSeekBarChangeListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     SeekBar bar=(SeekBar)findViewById(R.id.seekBar1);
     bar.setOnSeekBarChangeListener(this);
    }

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		TextView tv=(TextView)findViewById(R.id.textView2);
		tv.setText(Integer.toString(progress)+"%");
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
}