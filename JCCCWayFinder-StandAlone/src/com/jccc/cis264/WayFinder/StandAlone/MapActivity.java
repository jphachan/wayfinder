package com.jccc.cis264.WayFinder.StandAlone;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

@SuppressLint("NewApi")
public class MapActivity extends Activity {
	private GoogleMap map;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);

		if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext()) == 0)
		{
			//Start Map Application~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
			map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

			LatLng jccc = new LatLng(38.92356,-94.728327);

			map.setMyLocationEnabled(true);
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(jccc, 15));

			map.addMarker(new MarkerOptions()
			.title("JCCC")
			.snippet("The most populous city in Australia.")
			.position(jccc));

			map.moveCamera(CameraUpdateFactory.newLatLngZoom(jccc, 15));

			// Zoom in, animating the camera.
			map.animateCamera(CameraUpdateFactory.zoomIn());

			// Zoom out to zoom level 10, animating with a duration of 2 seconds.
			map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

			// Construct a CameraPosition focusing on Mountain View and animate the camera to that position.
			CameraPosition cameraPosition = new CameraPosition.Builder()
			.target(/*INSERT LOCATION HERE*/)      // Sets the center of the map to Mountain View
			.zoom(17)                   // Sets the zoom
			.bearing(90)                // Sets the orientation of the camera to east
			.tilt(30)                   // Sets the tilt of the camera to 30 degrees
			.build();                   // Creates a CameraPosition from the builder
			map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
			
			
			//End Map Application~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

}