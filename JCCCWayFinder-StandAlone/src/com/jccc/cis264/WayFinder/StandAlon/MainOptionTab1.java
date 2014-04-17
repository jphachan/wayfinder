package com.jccc.cis264.WayFinder.StandAlon;

import java.util.ArrayList;
import org.json.JSONObject;

import com.jccc.cis264.WayFinder.StandAlone.R;

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
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;


@SuppressWarnings("all")
public class MainOptionTab1 extends Activity {

	private Activity myActivity = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_option_tab1);
		final ArrayList<String> Destinations = new ArrayList();
		final Intent startMap = new Intent(this, MainOptions.class);
		TableLayout tl = (TableLayout) findViewById(R.id.tableLayout1);

		try{
			JSONObject json = new JSONObject(this.getIntent().getStringExtra("DATA"));
			final Student stud = new Student(json);
			final ArrayList<CheckBox> cbA = new ArrayList();



			for(int i = 0; i < stud.getTerm(0).getSections().size(); i++){
				String tempDayCodes = "";
				final int j = i;
				if(!stud.getTerm(0).getSections().get(i).isOnline()){
					if(i==0){
						final String DayCodes = tempDayCodes;
						TableRow tr = (TableRow) findViewById(R.id.tableRow1);
						RelativeLayout rl = (RelativeLayout) findViewById(R.id.RelLayoutTable);
						CheckBox cb = (CheckBox) findViewById(R.id.checkBox1);
						cb.setId(1000+i);
						Button btn = (Button) findViewById(R.id.button2);
						RelativeLayout.LayoutParams cbParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
						RelativeLayout.LayoutParams btnParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
						btnParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
						btn.setText("Details");
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
							}
							else{
								tempDayCodes += "- ";
							}
						}
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
			//================================================================================================================================================+==============


			
			Button takeMeThere = (Button) findViewById(R.id.TakeMeThere);
			
			takeMeThere.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Destinations.clear();

					for(int i = 0; cbA.size() > i; i++){
						if(cbA.get(i).isChecked()){
							int index = (cbA.get(i).getId() - 1000);
							System.out.println("Checkbox " + index + " is checked!");
							
							Destinations.add(stud.getTerm(0).getSection(index).getMeetingPattern(0).getBuildingId());
							
						}
					}
					System.out.println(Destinations);
					
				}
			});
			

			
			//================================================================================================================================================+==============
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
