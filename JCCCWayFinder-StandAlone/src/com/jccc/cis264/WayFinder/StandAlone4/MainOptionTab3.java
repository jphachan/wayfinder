package com.jccc.cis264.WayFinder.StandAlone4;

import org.json.JSONException;
import org.json.JSONObject;

import com.jccc.cis264.WayFinder.StandAlone.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainOptionTab3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_option_tab3);
		
        try {
			JSONObject json = new JSONObject(this.getIntent().getStringExtra("DATA"));
			TextView tv = (TextView) findViewById(R.id.Tab3TextBoxTest);
			tv.setText(json.toString());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_option_tab3, menu);
		return true;
	}

}
