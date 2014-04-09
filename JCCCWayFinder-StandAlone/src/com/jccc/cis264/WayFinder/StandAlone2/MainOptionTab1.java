package com.jccc.cis264.WayFinder.StandAlone2;

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
				if(json.getJSONArray("terms").getJSONObject(0).getJSONArray("sections").getJSONObject(i).getJSONArray("meetingPatterns").length() > 0){
					CheckBox cb = new CheckBox(myActivity);
					cb.setId(1000 + i);
					cb.setText(json.getJSONArray("terms").getJSONObject(0).getJSONArray("sections").getJSONObject(i).getString("sectionTitle") + "\n");

					ArrayList al = new ArrayList();
					for(int j = 0; json.getJSONArray("terms").getJSONObject(0).getJSONArray("sections").getJSONObject(i).getJSONArray("meetingPatterns").getJSONObject(0).getJSONArray("daysOfWeek").length() > j; j++){
						al.add(json.getJSONArray("terms").getJSONObject(0).getJSONArray("sections").getJSONObject(i).getJSONArray("meetingPatterns").getJSONObject(0).getJSONArray("daysOfWeek").getInt(j));
					}
					System.out.println(al);

					for(int k = 01; k < 8; k++){
						if(al.contains(k)){
							if(k == 1){
								cb.append("S");
							}
							else if(k == 2){
								cb.append("M");
							}

							else if(k == 3){
								cb.append("T");
							}

							else if(k == 4){
								cb.append("W");
							}

							else if(k == 5){
								cb.append("R");
							}

							else if(k == 6){
								cb.append("F");
							}

							else if(k == 7){
								cb.append("S");
							}
						}
						else{
							cb.append("-");
						}
					}
					
					cb.append("      " + json.getJSONArray("terms").getJSONObject(0).getJSONArray("sections").getJSONObject(i).getJSONArray("meetingPatterns").getJSONObject(0).getString("buildingId") + json.getJSONArray("terms").getJSONObject(0).getJSONArray("sections").getJSONObject(i).getJSONArray("meetingPatterns").getJSONObject(0).getString("room"));
					
					RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
							RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
					lp.addRule(RelativeLayout.BELOW, 1000 + i-1);


					rl.addView(cb, lp);
					System.out.println("test " + i);
				}
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
