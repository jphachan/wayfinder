 package com.jccc.cis264.WayFinder.StandAlone;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        final TextView userBox = (TextView) findViewById(R.id.UserBox);
        final TextView passBox = (TextView) findViewById(R.id.PassBox);
        
        //Login button handler

        final Button LoginButton = (Button) findViewById(R.id.LoginButton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	//Show Debug confirmation
            	System.out.println("Login Button Clicked");
            	//perform login actions
            	login(userBox.getText().toString(), passBox.getText().toString());
            }
        });

        
        //Cancel button handler
        final Button CancelButton = (Button) findViewById(R.id.CancelButton);
        CancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	//Show Debug confirmation
            	System.out.println("Cancel Button Clicked");
            	
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
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public void login(String username, String password){
    	System.out.println("Login Information // Username: " + username + " // Password: " + password);
    }
}
