package com.jccc.cis264.WayFinder.StandAlone1;


import java.util.ArrayList;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jccc.cis264.WayFinder.StandAlone.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Menu;

@SuppressWarnings("all")
@SuppressLint("newAPI")
public class MapActivity extends Activity {
	private GoogleMap map;
	private LatLng JcccCenter = new LatLng(38.92356,-94.728327),
			CC = new LatLng(38.9252624, -94.7279145),
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

	ArrayList<String> destinations;
	
	String type;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map );

		if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext()) == 0)
		{
			//Start Map Application~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
			type = getIntent().getExtras().getString("type");
			
			System.err.println(getIntent().getExtras().getString("type"));
			
			if(type.equals("") || type.equals("sat")){
				map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			}
			else if(type.equals("map")){
				map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			}
			else if(type.equals("hyb")){
				map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			}
			else if(type.equals("ter")){
				map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
			}
			else{
				map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			}

			map.moveCamera(CameraUpdateFactory.newLatLngZoom(JcccCenter, 15));
			
			destinations = getIntent().getExtras().getStringArrayList("Points");

			for(String s : destinations){
				makeMarker(s);
			}

			// Construct a CameraPosition focusing on Mountain View and animate the camera to that position.
			CameraPosition cameraPosition = new CameraPosition.Builder()
			.target(CC)      // Sets the center of the map to CC
			.zoom(16)        // Sets the zoom
			.build();        // Creates a CameraPosition from the builder
			map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 2000, null);

			//End Map Application~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	private void addMarker(GoogleMap gm, LatLng loc, String title){
		gm.addMarker(new MarkerOptions()
		.title(title)
		.position(loc));
	}

	//take an input building ID and output a LatLng
	private void makeMarker(String code){
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

		if(code == "LIB")
			addMarker(map, LIB, "Billington Library");
		else if(code.equals("CC"))
			addMarker(map, CC, "Carlson Center");
		else if(code.equals("RC"))
			addMarker(map, RC, "Regnier Center");
		else if(code.equals("OCB"))
			addMarker(map, OCB, "Office and Classroom Building");
		else if(code.equals("CLB"))
			addMarker(map, CLB, "Classroom Laboratory Building");
		else if(code.equals("HCA"))
			addMarker(map, HCA, "Hospitality and Culinary Academy");
		else if(code.equals("GP"))
			addMarker(map, GP, "Galileo\'s Pavilion");
		else if(code.equals("SC"))
			addMarker(map, SC, "Student Center");
		else if(code.equals("CSB"))
			addMarker(map, CSB, "Campus Services Building");
		else if(code.equals("ATB"))
			addMarker(map, ATB, "Arts and Technology Building");
		else if(code.equals("WLB"))
			addMarker(map, WLB, "Welding Lab Building");
		else if(code.equals("GYM"))
			addMarker(map, GYM, "Gymnasium");
		else if(code.equals("GEB"))
			addMarker(map, GEB, "General Education Building");
		else if(code.equals("COM"))
			addMarker(map, COM, "Commons building");
		else if(code.equals("HSC"))
			addMarker(map, HSC, "Horticultural Science Center");
		else if(code.equals("ITC"))
			addMarker(map, ITC, "Industrial Training Center");
		else if(code.equals("PA"))
			addMarker(map, PA, "Police Acadamy");
		else if(code.equals("SCI"))
			addMarker(map, SCI, "Science Building");
		else{

		}

	}
}

