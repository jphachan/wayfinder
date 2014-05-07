package com.jccc.cis264.WayFinder.StandAlone1;

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

		final Button GoButton1A = (Button) findViewById(R.id.GoButton2A);
		GoButton1A.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Destinations.clear();
				if(FromSpin.getSelectedItemPosition() == 0){
					Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + findLatLngByCode(destSpin.getSelectedItemPosition(), 0).latitude + "," + findLatLngByCode(destSpin.getSelectedItemPosition(), 0).longitude + "&mode=w"));
					myActivity.startActivity(intent);
				}
				else{
					Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=" + findLatLngByCode(FromSpin.getSelectedItemPosition(), 1).latitude + "," + findLatLngByCode(FromSpin.getSelectedItemPosition(), 1).longitude + "&daddr=" + findLatLngByCode(destSpin.getSelectedItemPosition(), 0).latitude + "," + findLatLngByCode(destSpin.getSelectedItemPosition(), 0).longitude + "&dirflg=r"));
					intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
					myActivity.startActivity(intent);
				}
			}
		});
	}


	private LatLng findLatLngByCode(int code, int offset){
		
		int use = code - offset;
		
		LatLng CC = new LatLng(38.9252624, -94.7279145),
				LIB = new LatLng(38.924214, -94.72767190000002),
				RC = new LatLng(38.9243700, -94.72684989999999),
				OCB = new LatLng(38.9245613,-94.728429),
				CLB = new LatLng(38.9233935, -94.7278336),
				SCI = new LatLng(38.9237222, -94.72876329999997),
				HCA = new LatLng(38.9230872,-94.72655580000003),
				GP = new LatLng(38.9233574, -94.7292281),
				SC = new LatLng(38.9245847, -94.73058229999998),
				CSB = new LatLng(38.9231457, -94.72993550000001),
				ATB = new LatLng(38.9231911,-94.7308248),
				WLB = new LatLng(38.9221687, -94.73094609999998),
				GYM = new LatLng(38.9240505, -94.73171409999998),
				GEB = new LatLng(38.924214, -94.7292281),
				COM = new LatLng(38.9245613,-94.72993550000001),
				HSC = new LatLng(38.9237438, -94.73527139999999),
				ITC = new LatLng(38.9225006, -94.73179490000001),
				PA = new LatLng(38.924395, -94.73527139999999);

		if(use == 1)
			return LIB;
		else if(use == 2)
			return CC;
		else if(use == 14)
			return RC;
		else if(use == 12)
			return OCB;
		else if(use == 4)
			return CLB;
		else if(use == 10)
			return HCA;
		else if(use == 6)
			return GP;
		else if(use == 16)
			return SC;
		else if(use == 3)
			return CSB;
		else if(use == 0)
			return ATB;
		else if(use == 17)
			return WLB;
		else if(use == 8)
			return GYM;
		else if(use == 7)
			return GEB;
		else if(use == 5)
			return COM;
		else if(use == 9)
			return HSC;
		else if(use == 11)
			return ITC;
		else if(use == 13)
			return PA;
		else if(use == 15)
			return SCI;
		else{
			return null;
		}
	
}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_option_tab2, menu);
		return true;
	}

}
