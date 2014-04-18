package com.jccc.cis264.WayFinder.StandAlone;

import java.util.ArrayList;
import org.json.JSONObject;

import com.google.android.gms.maps.model.LatLng;
import com.jccc.cis264.WayFinder.StandAlone.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;


@SuppressWarnings("all")
public class MainOptionTab1 extends Activity {
	boolean sAllState1 = true;
	private Activity myActivity = this;
	String DayCodes;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_option_tab1);
		final ArrayList<String> Destinations = new ArrayList();
		final Intent startMap = new Intent(this, MainOptions.class);
		TableLayout tl = (TableLayout) findViewById(R.id.tableLayout1);
		RadioButton defaultrb = (RadioButton) findViewById(R.id.auton_radio_1);
		defaultrb.setSelected(true);
		String tempDayCodes = null;
		
		
		try{
			JSONObject json = new JSONObject(this.getIntent().getStringExtra("DATA"));
			final Student stud = new Student(json);
			final ArrayList<CheckBox> cbA = new ArrayList();
			


			for(int i = 0; i < stud.getTerm(0).getSections().size(); i++){
				
				final int j = i;
				if(!stud.getTerm(0).getSections().get(i).isOnline()){
					if(i==0){
						
						TableRow tr = (TableRow) findViewById(R.id.tableRow1);
						RelativeLayout rl = (RelativeLayout) findViewById(R.id.RelLayoutTable);
						CheckBox cb = (CheckBox) findViewById(R.id.checkBox1);
						cb.setId(1000+i);
						Button btn = (Button) findViewById(R.id.button2);
						RelativeLayout.LayoutParams cbParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
						RelativeLayout.LayoutParams btnParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
						btnParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
						btn.setText("Details");
						tempDayCodes = "";
						for(int k = 01; k < 8; k++){
							if(stud.getTerm(0).getSection(j).getMeetingPattern(0).getDaysOfWeek().contains(k)){
								if(k == 1){
									tempDayCodes += "S ";
								}
								else if(k == 2){
									tempDayCodes += "M ";
								}
								else if(k == 3){
									tempDayCodes += "T ";
								}
								else if(k == 4){
									tempDayCodes += "W ";
								}
								else if(k == 5){
									tempDayCodes += "R ";
								}
								else if(k == 6){
									tempDayCodes += "F ";
								}
								else if(k == 7){
									tempDayCodes += "S ";
								}
								System.out.println(tempDayCodes);
							}
							else{
								tempDayCodes += "- ";
								System.out.println(tempDayCodes);
							}
							
						}
						DayCodes = tempDayCodes;
						tempDayCodes = "";
						btn.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								//create a new AlertDialog
								AlertDialog.Builder Alert  = new AlertDialog.Builder(myActivity);
								//set message of alert
								//================================================================================================================================================
								Alert.setMessage("Course Name: \n" + stud.getTerm(0).getSection(j).getSectionTitle() + "\n\n" + 
										"Course Section: \n" + stud.getTerm(0).getSection(j).getCourseName() + "\n\n" + 
										"Class Days: \n" + DayCodes);
								//================================================================================================================================================
								//set Title of alert
								Alert.setTitle("Course Details");
								//set button text
								Alert.setPositiveButton("CLOSE", null);
								Alert.setCancelable(true);
								//show alert
								Alert.create().show();
								//script button handler
								Alert.setPositiveButton("Ok",
										new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog, int which) {
										//button handler is left blank. Its only function is to close the alert, which is default.
									}
								}
										);
							}
						});
						cbParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
						cb.setText(stud.getTerm(0).getSection(j ).getSectionTitle());
						cbA.add(cb);
						
					}
					else{
						TableRow tr1 = new TableRow(myActivity);
						RelativeLayout rl1 = new RelativeLayout(myActivity);
						CheckBox cb1 = new CheckBox(myActivity);
						cb1.setId(1000+i);
						Button btn1 = new Button(myActivity);
						View v1 = new View(this);
						v1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 1));
						v1.setBackgroundColor(Color.rgb(51, 51, 51));	
						RelativeLayout.LayoutParams cbParams1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
						RelativeLayout.LayoutParams btnParams1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
						btnParams1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
						btn1.setText("Details");
						for(int k = 01; k < 8; k++){
							if(stud.getTerm(0).getSection(i).getMeetingPattern(0).getDaysOfWeek().contains(k)){
								if(k == 1){
									tempDayCodes += "S ";
								}
								else if(k == 2){
									tempDayCodes += "M ";
								}
								else if(k == 3){
									tempDayCodes += "T ";
								}
								else if(k == 4){
									tempDayCodes += "W ";
								}
								else if(k == 5){
									tempDayCodes += "R ";
								}
								else if(k == 6){
									tempDayCodes += "F ";
								}
								else if(k == 7){
									tempDayCodes += "S ";
								}
							}
							else{
								tempDayCodes += "- ";
							}
						}
						final String DayCodes2 = tempDayCodes;
						tempDayCodes = "";
						btn1.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								//create a new AlertDialog
								AlertDialog.Builder Alert  = new AlertDialog.Builder(myActivity);
								//set message of alert
								//================================================================================================================================================
								Alert.setMessage("Course Name: \n" + stud.getTerm(0).getSection(j).getSectionTitle() + "\n\n" + 
										"Course Section: \n" + stud.getTerm(0).getSection(j).getCourseName() + "\n\n" + 
										"Class Days: \n" + DayCodes2);
								//================================================================================================================================================
								//set Title of alert
								Alert.setTitle("Course Details");
								//set button text
								Alert.setPositiveButton("CLOSE", null);
								Alert.setCancelable(true);
								//show alert
								Alert.create().show();
								//script button handler
								Alert.setPositiveButton("Ok",
										new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog, int which) {
										//button handler is left blank. Its only function is to close the alert, which is default.
									}
								}
										);
							}
						});
						
						cbParams1.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
						cb1.setText(stud.getTerm(0).getSection(i).getSectionTitle());
						rl1.addView(cb1, cbParams1);
						rl1.addView(btn1, btnParams1);
						tr1.addView(rl1);
						tl.addView(tr1);
						tl.addView(v1);
						cbA.add(cb1);
					}
				}
			}
			//==============================================================================================================================================================


			
			Button takeMeThere = (Button) findViewById(R.id.tmt);		
			takeMeThere.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					int numChecked = 0;
					CheckBox tempcheck = null;
					int checkedIndex = 0;
					
					for(int i = 0; cbA.size() > i; i++){
						if(cbA.get(i).isChecked()){
							 numChecked++;
							 checkedIndex = i;
						}
					}
					
					if(numChecked == 1){
						System.out.println(checkedIndex);
						System.out.println(stud.getTerm(0).getSection(checkedIndex).getMeetingPattern(0).getBuildingId());
						System.out.println(findLatLngByCode(stud.getTerm(0).getSection(checkedIndex).getMeetingPattern(0).getBuildingId()));
						Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + findLatLngByCode(stud.getTerm(0).getSection(checkedIndex).getMeetingPattern(0).getBuildingId()).latitude + "," + findLatLngByCode(stud.getTerm(0).getSection(checkedIndex).getMeetingPattern(0).getBuildingId()).longitude + "&mode=w"));
						myActivity.startActivity(intent);	
					}
					else if(numChecked == 0){
						//create a new AlertDialog
						AlertDialog.Builder Alert  = new AlertDialog.Builder(myActivity);
						//set message of alert
						//================================================================================================================================================
						Alert.setMessage("Please select a course to navigate to!");
						//================================================================================================================================================
						//set Title of alert
						Alert.setTitle("Could Not Navigate!");
						//set button text
						Alert.setPositiveButton("OK", null);
						Alert.setCancelable(true);
						//show alert
						Alert.create().show();
						//script button handler
						Alert.setPositiveButton("Ok",
								new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								//button handler is left blank. Its only function is to close the alert, which is default.
							}
						}
								);
					}
					else{
						//create a new AlertDialog
						AlertDialog.Builder Alert  = new AlertDialog.Builder(myActivity);
						//set message of alert
						//================================================================================================================================================
						Alert.setMessage("Please select only one course to navigate to!");
						//================================================================================================================================================
						//set Title of alert
						Alert.setTitle("Could Not Navigate!");
						//set button text
						Alert.setPositiveButton("OK", null);
						Alert.setCancelable(true);
						//show alert
						Alert.create().show();
						//script button handler
						Alert.setPositiveButton("Ok",
								new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								//button handler is left blank. Its only function is to close the alert, which is default.
							}
						}
								);
					}
					
				}
			});

			
			final Button sAll = (Button) findViewById(R.id.sAll);		
			sAll.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					for(int i = 0; cbA.size() > i; i++){
						cbA.get(i).setChecked(sAllState1);
					}
					
					if(sAllState1 == true){
						sAll.setText("Deselect All");
						sAllState1 = false;
					}
					else{
						sAll.setText("Select All");
						sAllState1 = true;
					}
					
				}
			});
			
			//==============================================================================================================================================================
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
	
	private LatLng findLatLngByCode(String code){
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
			return LIB;
		else if(code.equals("CC"))
			return CC;
		else if(code.equals("RC"))
			return RC;
		else if(code.equals("OCB"))
			return OCB;
		else if(code.equals("CLB"))
			return CLB;
		else if(code.equals("HCA"))
			return HCA;
		else if(code.equals("GP"))
			return GP;
		else if(code.equals("SC"))
			return SC;
		else if(code.equals("CSB"))
			return CSB;
		else if(code.equals("ATB"))
			return ATB;
		else if(code.equals("WLB"))
			return WLB;
		else if(code.equals("GYM"))
			return GYM;
		else if(code.equals("GEB"))
			return GEB;
		else if(code.equals("COM"))
			return COM;
		else if(code.equals("HSC"))
			return HSC;
		else if(code.equals("ITC"))
			return ITC;
		else if(code.equals("PA"))
				
			return PA;
		else if(code.equals("SCI"))
			return SCI;
		else{
			return null;
		}
		
	}
	
}
