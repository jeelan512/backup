package com.example.toggletoast;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	String arr[] = {"15","30","40","50"};
	SharedPreferences shared;
	Editor edt;
	static int indexx; 
	int i;
	int len;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	/*	shared = getSharedPreferences("file", 0);*/
		
		
	}
	
	public void ToggleToast(View v){
		//edt = shared.edit();
		len= arr.length;
		for(i=indexx;i<len;i++){
			/*edt.putInt("index", i);
			edt.commit();*/
			Toast.makeText(getApplicationContext(), "Sleep Timer: "+arr[i], Toast.LENGTH_LONG).show();
			break;
		}
		++indexx;
		if(indexx == len){
			indexx = 0;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
