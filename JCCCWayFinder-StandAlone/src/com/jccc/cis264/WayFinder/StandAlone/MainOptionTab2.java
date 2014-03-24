package com.jccc.cis264.WayFinder.StandAlone;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
@SuppressWarnings({ "all" })
public class MainOptionTab2 extends Activity {

	private Activity myActivity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_option_tab2);

		final Spinner destSpin = (Spinner) findViewById(R.id.spinner2);
		final ArrayList<String> Destinations = new ArrayList();
		final Intent startMap = new Intent(this, MainOptions.class);
		final ArrayList<String> valueArray = new ArrayList();

		valueArray.add("ATB"); valueArray.add("LIB"); valueArray.add("CC"); valueArray.add("CSB"); valueArray.add("CLB"); valueArray.add("GP"); valueArray.add("GEB"); valueArray.add("GYM"); valueArray.add("HSC"); valueArray.add("HCA"); valueArray.add("ITC"); valueArray.add("OCB"); valueArray.add("PA"); valueArray.add("RC"); valueArray.add("SCI"); valueArray.add("SC"); valueArray.add("WLB");

		final Button GoButton1A = (Button) findViewById(R.id.GoButton2A);
		GoButton1A.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Destinations.clear();

				Destinations.add(valueArray.get(destSpin.getSelectedItemPosition()));
				System.out.println(Destinations);
				startMap.removeExtra("Destination Array");
				startMap.putStringArrayListExtra("Destination Array", Destinations);
				//myActivity.startActivity(startMap);
			}
		});
	}


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_option_tab2, menu);
		return true;
	}

}
