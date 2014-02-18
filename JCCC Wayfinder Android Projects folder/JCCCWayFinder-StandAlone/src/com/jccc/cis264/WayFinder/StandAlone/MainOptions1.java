package com.jccc.cis264.WayFinder.StandAlone;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainOptions1 extends Activity {

	public static String username, password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_options1);
		final Activity thisActivity = this;
		//Handle IntentExtras
		Intent Reciever = getIntent();
		username = Reciever.getExtras().get("USERNAME").toString();
		password = Reciever.getExtras().get("PASSWORD").toString();
		final Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//perform login actions
				try {

					Intent startOptions = new Intent(thisActivity, MapActivity.class);
					startActivity(startOptions);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_options1, menu);
		return true;
	}

}
