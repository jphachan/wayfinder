package com.jccc.cis264.WayFinder.StandAlone8;

import org.json.JSONException;
import org.json.JSONObject;

import com.jccc.cis264.WayFinder.StandAlone.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;


@SuppressWarnings("all")
public class MainOptions extends TabActivity {
	private JSONObject APIdata = new JSONObject();
    private TabHost mTabHost;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_options1);
        mTabHost = getTabHost();
        mTabHost.setup();

        try {
			APIdata = new JSONObject(this.getIntent().getStringExtra("ALLDATA"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Intent intentAndroid1 = new Intent().setClass(this,MainOptionTab1.class);
        intentAndroid1.putExtra("DATA", this.getIntent().getStringExtra("ALLDATA"));
        TabSpec tab1 = mTabHost
                .newTabSpec("Android")
                .setIndicator("By Schedule")
                .setContent(intentAndroid1);

        Intent intentAndroid2 = new Intent().setClass(this,MainOptionTab2.class);
        TabSpec tab2 = mTabHost
                .newTabSpec("Android")
                .setIndicator("By Building")
                .setContent(intentAndroid2);
        
        Intent intentAndroid3 = new Intent().setClass(this,MainOptionTab3.class);
        intentAndroid3.putExtra("DATA", this.getIntent().getStringExtra("ALLDATA"));
        TabSpec tab3 = mTabHost
                .newTabSpec("Android")
                .setIndicator("Today")
                .setContent(intentAndroid3);

        mTabHost.addTab(tab1);
        mTabHost.addTab(tab2);
        mTabHost.addTab(tab3);
    }
}
