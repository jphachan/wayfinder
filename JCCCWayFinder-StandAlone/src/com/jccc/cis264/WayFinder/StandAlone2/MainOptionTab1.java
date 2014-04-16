package com.jccc.cis264.WayFinder.StandAlone2;

import java.util.ArrayList;
import org.json.JSONObject;
import com.jccc.cis264.WayFinder.StandAlone.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;


@SuppressWarnings("all")
public class MainOptionTab1 extends Activity {

	private Activity myActivity = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_option_tab1);

		final ArrayList<String> Destinations = new ArrayList();
		final Intent startMap = new Intent(this, MainOptions.class);
		try{
		JSONObject json = new JSONObject(this.getIntent().getStringExtra("DATA"));
		}catch(Exception e){
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
