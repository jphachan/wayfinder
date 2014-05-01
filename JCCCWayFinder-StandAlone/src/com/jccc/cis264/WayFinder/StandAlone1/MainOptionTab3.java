package com.jccc.cis264.WayFinder.StandAlone1;

import java.util.ArrayList;
import java.util.Calendar;

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
public class MainOptionTab3 extends Activity {
	//the state of all checkboxes
	boolean sAllState1 = true;

	//the current activity
	private Activity myActivity = this;

	//a dynamically built string of daycodes
	String DayCodes;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_option_tab3);

		//an arraylist of the selected 
		final ArrayList<String> Destinations = new ArrayList();
		//the custom-map intent
		final Intent startMap = new Intent(this, MainOptions.class);

		//Perform initialization for the first interface CheckBox
		//assign the first CheckBox to a variable
		TableLayout tl = (TableLayout) findViewById(R.id.tableLayout2);
		//assign the first button to a variable
		RadioButton defaultrb = (RadioButton) findViewById(R.id.auton_radio_4);
		//set the default selected radio button
		defaultrb.setSelected(true);

		//initialize daycodes string
		String tempDayCodes = null;


		//Open the try/catch to catch any exception that can arise, including JSONException
		try{
			//initialize the JSON data procided from the login process, and send it to a student object
			JSONObject json = new JSONObject(this.getIntent().getStringExtra("DATA"));
			final Student stud = new Student(json);
			//initialize an array to store created checkboxes, along with information about them
			final ArrayList<CheckBox> cbA = new ArrayList();

			for(int i = 0; i < stud.getTerm(0).getSections().size(); i++){
				final int j = i;

				if(!stud.getTerm(0).getSections().get(i).isOnline()){
					if(stud.getTerm(0).getSection(i).getMeetingPattern().getDaysOfWeek().contains(Calendar.getInstance().get(Calendar.DAY_OF_WEEK))){
						if(i==0){
							//set the first TableRow to an object
							TableRow tr = (TableRow) findViewById(R.id.tableRow2);
							//set the first RelativeLayout to an object
							RelativeLayout rl = (RelativeLayout) findViewById(R.id.RelLayoutTable2);
							//set the first CheckBox to an object
							CheckBox cb = (CheckBox) findViewById(R.id.checkBox2);

							//set the id of the Checkbox dynamically to 1000 + the index of the course.  For instance, 1000 + 0
							cb.setId(1000 + stud.getTerm(0).getSection(j).getSectionNumber());
							//set the first Button to an object
							Button btn = (Button) findViewById(R.id.button4);

							//create the layout paramters needed for the checkbox and the button
							RelativeLayout.LayoutParams cbParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
							RelativeLayout.LayoutParams btnParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
							btnParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

							//set the button text
							btn.setText("Details");

							//draw the daycodes as a text string
							tempDayCodes = "";
							for(int k = 01; k < 8; k++){
								if(stud.getTerm(0).getSection(j).getMeetingPattern().getDaysOfWeek().contains(k)){
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
							//move the daycode string to a final variable, then reset the daycodes for the next run
							DayCodes = tempDayCodes;
							tempDayCodes = "";

							//set the onclick listener for the button
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

							//create add additional rules to the checkbox params to center it vertically within its own row
							cbParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
							//set checkbox text to the course name
							cb.setText(stud.getTerm(0).getSection(j ).getSectionTitle());
							//add the checkbox to the checkbox array
							cbA.add(cb);
						}
						else{
							//create a new table row
							TableRow tr1 = new TableRow(myActivity);
							//create a new relative layout
							RelativeLayout rl1 = new RelativeLayout(myActivity);
							//create a new checkbox
							CheckBox cb1 = new CheckBox(myActivity);
							//set the id of the Checkbox dynamically to 1000 + the index of the course.  For instance, 1000 + 0
							cb1.setId(1000 + stud.getTerm(0).getSection(i).getSectionNumber());
							//create a new button
							Button btn1 = new Button(myActivity);
							//create a new view (Used as a horizontal Separator
							View v1 = new View(this);
							//format the vew v1
							v1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 1));
							v1.setBackgroundColor(Color.rgb(51, 51, 51));

							//create layout parameters for the checkbox and button
							RelativeLayout.LayoutParams cbParams1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
							RelativeLayout.LayoutParams btnParams1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
							btnParams1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

							//set the title of the button
							btn1.setText("Details");

							//create a dynamically generated string of TEXT daycodes
							for(int k = 01; k < 8; k++){
								if(stud.getTerm(0).getSection(i).getMeetingPattern().getDaysOfWeek().contains(k)){
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

							//transfer the daycode strong to a final variable
							final String DayCodes2 = tempDayCodes;
							tempDayCodes = "";

							//set the action listener of the details button
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


							//center the checkbox vertically in its unique row
							cbParams1.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);

							//set the checkbox text to the name of the course
							cb1.setText(stud.getTerm(0).getSection(i).getSectionTitle());

							//add all dynamically created elements to the activity, using custom layout params where applicable
							rl1.addView(cb1, cbParams1);
							rl1.addView(btn1, btnParams1);
							tr1.addView(rl1);
							tl.addView(tr1);
							tl.addView(v1);

							//add the checkbox to the array of checkboxes
							cbA.add(cb1);
						}
					}
				}
			}
			//==============================================================================================================================================================


			//make the TakeMeThere button into an object, then specify its 
			Button takeMeThere = (Button) findViewById(R.id.tmt2);		
			takeMeThere.setOnClickListener(new View.OnClickListener() {
				@Override

				//the action performed when clicked
				public void onClick(View v) {
					//create an initialize a counter to be used to store the number of checked checkboxes
					int numChecked = 0;
					//used if there is a single CheckBox selected;
					CheckBox tempcheck = null;
					//the index of the selected CheckBox
					int checkedIndex = 0;

					//run a loop through EVERY CheckBox to check the state of each CheckBox
					for(int i = 0; cbA.size() > i; i++){
						//if the current CheckBox is checked, then add it to the temporary CheckBox object, and increase the CB counter by one
						if(cbA.get(i).isChecked()){
							numChecked++;
							checkedIndex = cbA.get(i).getId() - 1000;
						}
					}

					//if only one course is checked
					if(numChecked == 1){
						//create a new intent referencing the device's Google Navigation package, supplying the app query with the LatLng of the selected course
						Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + findLatLngByCode(stud.getTerm(0).getSection(checkedIndex).getMeetingPattern().getBuildingId()).latitude + "," + findLatLngByCode(stud.getTerm(0).getSection(checkedIndex).getMeetingPattern().getBuildingId()).longitude + "&mode=w"));
						//run the intent, launching Google Navigation outside of this application
						myActivity.startActivity(intent);	
					}
					//if no course is selected
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
					//if more than one course is selected
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

			//make the TakeMeThere button into an object, then specify its 
			Button ShowMeAMap = (Button) findViewById(R.id.smam2);		
			ShowMeAMap.setOnClickListener(new View.OnClickListener() {
				//the action performed when clicked
				@Override
				public void onClick(View v) {
					int numChecked = 0;
					Destinations.clear();
					//run a loop through EVERY CheckBox to check the state of each CheckBox
					for(int i = 0; cbA.size() > i; i++){
						//if the current CheckBox is Checked, then increase the Checked counter by one
						if(cbA.get(i).isChecked()){
							numChecked++;
						}
					}	
					//if only one course is checked
					if(numChecked == 0){
					}
					//if no course is selected
					else{	
						for(int i = 0; cbA.size() > i; i++){
							//if the current CheckBox is checkec, then add it to the temporary CheckBox object, and increase the CB counter by one
							if(cbA.get(i).isChecked()){
								Destinations.add(stud.getTerm(0).getSection(cbA.get(i).getId() - 1000).getMeetingPattern().getBuildingId());
							}
						}	
						System.out.println(Destinations);
						Intent Map = new Intent(myActivity, MapActivity.class);
						Map.putExtra("Points", Destinations);
						myActivity.startActivity(Map);
					}
				}
			});

			//Select or Unselect all
			final Button sAll = (Button) findViewById(R.id.sAll2);		
			sAll.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {

					//when the button is clicked, run through and set EVERY checkbox to the state of sAllState1
					for(int i = 0; cbA.size() > i; i++){
						cbA.get(i).setChecked(sAllState1);
					}

					//if the last run was to select all, then set the next run to deselect all
					if(sAllState1 == true){
						sAll.setText("Deselect All");
						sAllState1 = false;
					}
					//if the last run was to deselect all, then set the next run to select all
					else{
						sAll.setText("Select All");
						sAllState1 = true;
					}

				}
			});

			//==============================================================================================================================================================
			//if an unhandled exception occures, print the trace to the debugger
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_option_tab2, menu);
		return true;
	}

	//take an input building ID and output a LatLng
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
