package com.jccc.cis264.WayFinder.StandAlone;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainOptionTab1 extends Activity {

	private Activity myActivity = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_option_tab1);
		
		final ArrayList<String> Destinations = new ArrayList();
		final Intent startMap = new Intent(this, MainOptions.class);
		
		final Button GoButton1A = (Button) findViewById(R.id.GoButton1A);
		GoButton1A.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//perform login actions
				
				startMap.putStringArrayListExtra("Destination Array", Destinations);
				myActivity.startActivity(startMap);
			}
		});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_option_tab1, menu);
		return true;
	}

}
