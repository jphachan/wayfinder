package com.jccc.cis264.WayFinder.StandAlon;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;
import com.jccc.cis264.WayFinder.StandAlone.R;

import android.net.Uri;
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
		final Spinner FromSpin = (Spinner) findViewById(R.id.spinner1);
		final ArrayList<String> Destinations = new ArrayList();
		final Intent startMap;
		final ArrayList<String> valueArray = new ArrayList();

		final LatLng[] location = {new LatLng(38.9231911,-94.7308248), 
				new LatLng(38.924214, -94.72767190000002),
				new LatLng(38.9252624, -94.7279145),
				new LatLng(38.9231457, -94.72993550000001),
				new LatLng(38.9233935, -94.7278336),
				new LatLng(38.9233574, -94.7292281),
				new LatLng(38.924214, -94.7292281),
				new LatLng(38.9240505, -94.73171409999998),
				new LatLng(38.9237438, -94.73527139999999),
				new LatLng(38.9230872,-94.72655580000003),
				new LatLng(38.9225006, -94.73179490000001),
				new LatLng(38.9245613,-94.728429),
				new LatLng(38.924395, -94.73527139999999),
				new LatLng(38.9243700, -94.72684989999999),
				new LatLng(38.9237222, -94.72876329999997),
				new LatLng(38.9245847, -94.73058229999998),
				new LatLng(38.9221687, -94.73094609999998)};

		valueArray.add("ATB"); valueArray.add("LIB"); valueArray.add("CC"); valueArray.add("CSB"); valueArray.add("CLB"); valueArray.add("GP"); valueArray.add("GEB"); valueArray.add("GYM"); valueArray.add("HSC"); valueArray.add("HCA"); valueArray.add("ITC"); valueArray.add("OCB"); valueArray.add("PA"); valueArray.add("RC"); valueArray.add("SCI"); valueArray.add("SC"); valueArray.add("WLB");

		final Button GoButton1A = (Button) findViewById(R.id.GoButton2A);
		GoButton1A.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Destinations.clear();
				if(FromSpin.getSelectedItemPosition() == 0){
					Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + location[destSpin.getSelectedItemPosition()].latitude + "," + location[destSpin.getSelectedItemPosition()].longitude + "&mode=w"));
					myActivity.startActivity(intent);
				}
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
