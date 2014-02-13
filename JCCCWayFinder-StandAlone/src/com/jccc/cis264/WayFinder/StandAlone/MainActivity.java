package com.jccc.cis264.WayFinder.StandAlone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public static Activity MyActivity;
	public static TextView userBox, passBox;
	public static ProgressDialog pro_dialog;
	public static boolean LoginSuccessful;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MyActivity = this;
		userBox = (TextView) findViewById(R.id.UserBox);
		passBox = (TextView) findViewById(R.id.PassBox);
		//Login button handler

		final Button LoginButton = (Button) findViewById(R.id.LoginButton);
		LoginButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//perform login actions
				try {
					pro_dialog = new ProgressDialog(MyActivity);
					pro_dialog.setTitle("Logging In...");
					pro_dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					pro_dialog.setMax(14);
					pro_dialog.show();
					new LoginRequest().execute();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		//Cancel button handler
		final Button CancelButton = (Button) findViewById(R.id.CancelButton);
		CancelButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Exit application
				showExitPrompt(0);
			}
		});
	}


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Display a dialog message
	public void showExitPrompt(final int exitCode){
		//create prompt object
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		//set up prompt
		builder.setTitle("Confirm");
		builder.setMessage("Are you sure you wish to exit?");

		//Yes option
		builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				//Exit APPLICATION with specified exit code
				finish();
			}
		});

		//No option
		builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//Close dialog
				dialog.dismiss();
			}
		});

		//Show prompt
		AlertDialog alert = builder.create();
		alert.show();
	}

	//Display a dialog message
	public void showLoginFailed(){
		//create prompt object
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		//set up prompt
		builder.setTitle("Confirm");
		builder.setMessage("Are you sure you wish to exit?");

		//Yes option
		builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				//Exit APPLICATION with specified exit code
				finish();
			}
		});

		//No option
		builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//Close dialog
				dialog.dismiss();
			}
		});

		//Show prompt
		AlertDialog alert = builder.create();
		alert.show();
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}

class LoginRequest extends AsyncTask<String, Integer, Integer> {
	@SuppressWarnings("deprecation")
	@Override
	protected Integer doInBackground(String... params) {
		try{
			MainActivity.pro_dialog.incrementProgressBy(1);
			//Setup environment variables from the main class
			Activity activity = MainActivity.MyActivity;
			String username = MainActivity.userBox.getText().toString();
			String password = MainActivity.passBox.getText().toString();
			MainActivity.pro_dialog.incrementProgressBy(1);
			String tempSrcRead = "", tempStr = "";
			MainActivity.pro_dialog.incrementProgressBy(1);

			//Initialize and open the SQL Handler API
			URL loginserver = null;
			MainActivity.pro_dialog.incrementProgressBy(1);
			System.out.println("PreURL");
			loginserver = new URL("http://jcccwayfinder.site40.net/databaseHandler.php?username=" + username + "&password=" + password);
			System.out.println("PostURL");
			MainActivity.pro_dialog.incrementProgressBy(1);
			loginserver.openConnection().setReadTimeout(10000);
			MainActivity.pro_dialog.incrementProgressBy(1);
			//Get information from the API
			MainActivity.pro_dialog.incrementProgressBy(1);

			BufferedReader in2 = null;
			//Read the response data	    	MainActivity.pro_dialog.incrementProgressBy(1);
			in2 = new BufferedReader(new InputStreamReader(loginserver.openConnection().getInputStream()));
			MainActivity.pro_dialog.incrementProgressBy(1);
			//tempStr = tempStr + "{";
			//PARSE JSON data
			while(tempSrcRead != null){
				tempSrcRead = in2.readLine();
				if(tempSrcRead != null){
					tempStr = tempStr + tempSrcRead;
				}
			}
			MainActivity.pro_dialog.incrementProgressBy(1);

			try{
				tempStr = tempStr.replace("<!-- Hosting24 Analytics Code --><script type=\"text/javascript\" src=\"http://stats.hosting24.com/count.php\"></script><!-- End Of Analytics Code -->", "");
				tempStr = tempStr.replace("[", "");
				tempStr = tempStr.replace("]", "");
				MainActivity.pro_dialog.incrementProgressBy(1);
				if(tempStr == ""){
					System.out.println("EmptyReturn");
					MainActivity.MyActivity.runOnUiThread(new Runnable() {
						public void run() {
							//dismiss loading bar
							MainActivity.pro_dialog.dismiss();
							//create a new AlertDialog
							AlertDialog.Builder Alert  = new AlertDialog.Builder(MainActivity.MyActivity);
							//set message of alert
							Alert.setMessage("Incorrect password or username");
							//set Title of alert
							Alert.setTitle("Login Failed!");
							//set button text
							Alert.setPositiveButton("OK", null);
							Alert.setCancelable(true);
							//show alert
							Alert.create().show();
							//script button handler
							Alert.setPositiveButton("Ok",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int which) {
										//button handler is left blank. Its only function is to close the alert, which is default.
									}
								}
							);
						}
					});
					//End of alert dialogs
				}
				else{
					JSONObject ldata = new JSONObject(tempStr);
					System.out.println(ldata.length());

						//Create a new intent used to open the next activity
						Intent startOptions = new Intent(activity, MainOptions1.class);
						MainActivity.pro_dialog.incrementProgressBy(1);
						//put the transfered data needed in the next pane
						startOptions.putExtra("USERNAME", username);
						startOptions.putExtra("PASSWORD", password);
						MainActivity.pro_dialog.incrementProgressBy(1);
						//start the activity
						MainActivity.pro_dialog.dismiss();

						activity.startActivity(startOptions);
					
				}	
			}catch(Exception e){				
				//~!~Occurs if the user did not enter valid data in one of the login fields *OR* if the Username was not found in the database.
				//Display login error message
				e.printStackTrace();
				MainActivity.MyActivity.runOnUiThread(new Runnable() {
					public void run() {
						//dismiss loading bar
						MainActivity.pro_dialog.dismiss();
						//create a new AlertDialog
						AlertDialog.Builder Alert  = new AlertDialog.Builder(MainActivity.MyActivity);
						//set message of alert
						Alert.setMessage("Incorrect password or username");
						//set Title of alert
						Alert.setTitle("Login Failed!");
						//set button text
						Alert.setPositiveButton("OK", null);
						Alert.setCancelable(true);
						//show alert
						Alert.create().show();
						//script button handler
						Alert.setPositiveButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int which) {
									//button handler is left blank. Its only function is to close the alert, which is default.
								}
							}
						);
					}
				});
				//End of alert dialog
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	//Display a dialog message
	public void showLoginFailure(){
		//create prompt object
	}
}
