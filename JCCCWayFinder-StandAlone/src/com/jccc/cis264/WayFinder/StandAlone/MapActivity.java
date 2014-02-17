package com.jccc.cis264.WayFinder.StandAlone;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.support.v4.app.FragmentActivity;

@SuppressLint("NewApi")
public class MapActivity extends FragmentActivity {
	private GoogleMap map;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);

        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext()) == 0)
        {
            map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            
    		LatLng jccc = new LatLng(38.92356,-94.728327);

            map.setMyLocationEnabled(true);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(jccc, 17));

            map.addMarker(new MarkerOptions()
                    .title("JCCC")
                    .snippet("The most populous city in Australia.")
                    .position(jccc));
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

}
