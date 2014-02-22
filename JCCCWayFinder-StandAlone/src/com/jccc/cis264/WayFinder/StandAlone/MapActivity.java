package com.jccc.cis264.WayFinder.StandAlone;


import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

@SuppressLint("NewApi")
public class MapActivity extends Activity{
	private GoogleMap map;
	private LatLng JcccCenter = new LatLng(38.92356,-94.728327),
			CC = new LatLng(38.92356,-94.728327);


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map );

		if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext()) == 0)
		{
			//Start Map Application~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
			map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

			map.setMyLocationEnabled(true);
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(JcccCenter, 15));

			map.addMarker(new MarkerOptions()
			.title("JCCC")
			.snippet("Johnson County community College")
			.position(JcccCenter));

			// Construct a CameraPosition focusing on Mountain View and animate the camera to that position.
			CameraPosition cameraPosition = new CameraPosition.Builder()
			.target(CC)      // Sets the center of the map to CC
			.zoom(17)        // Sets the zoom
			.build();        // Creates a CameraPosition from the builder
			map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 2000, null);
			//End Map Application~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			Polyline line1 = map.addPolyline(new PolylineOptions()
			 .add(new LatLng(50.5, 34.1), new LatLng(40.7, -74.0))
			 .width(5)
			 .color(0xFFFF0000));
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

}