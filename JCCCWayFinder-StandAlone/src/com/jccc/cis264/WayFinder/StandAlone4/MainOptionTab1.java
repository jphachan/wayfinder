package com.jccc.cis264.WayFinder.StandAlone4;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.jccc.cis264.WayFinder.StandAlone.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainOptionTab1 extends Activity {

	private Activity myActivity = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_option_tab1);

		final ArrayList<String> Destinations = new ArrayList();
		final Intent startMap = new Intent(this, MainOptions.class);
		
		RelativeLayout rl = (RelativeLayout) findViewById(R.id.RelativeLayout2);

		try {
			JSONObject json = new JSONObject(this.getIntent().getStringExtra("DATA"));
			for(int i = 0; json.getJSONArray("terms").getJSONObject(0).getJSONArray("sections").length() > i ; i++){
				CheckBox cb = new CheckBox(myActivity);
				cb.setId(1000 + i);
				cb.setText(json.getJSONArray("terms").getJSONObject(0).getJSONArray("sections").getJSONObject(i).getString("sectionTitle"));
				
				RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
				        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
				lp.addRule(RelativeLayout.BELOW, 1000 + i-1);
				
				rl.addView(cb, lp);
				System.out.println("test " + i);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_option_tab1, menu);
		return true;
	}

}
