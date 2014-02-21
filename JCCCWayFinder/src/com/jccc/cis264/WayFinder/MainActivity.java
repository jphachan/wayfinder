package com.jccc.cis264.WayFinder;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        WebView webview = new WebView(this);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setBuiltInZoomControls(true);
	    webSettings.setAppCacheEnabled(true);
	    webSettings.setDatabaseEnabled(true);
	    webSettings.setDomStorageEnabled(true);
	    
        webview.setWebChromeClient(new WebChromeClient() {
        	public void onGeolocationPermissionsShowPrompt(String origin, android.webkit.GeolocationPermissions.Callback callback) 
        	{ 
        		callback.invoke(origin, true, false); 
        	}
        	});
        webview.getSettings().setDatabasePath(STORAGE_SERVICE);
        
        setContentView(webview);
        webview.loadUrl("http://students.jccc.edu/jphachan/map.html");
        //webview.loadData("https://raw2.github.com/jphachan/wayfinder/master/map.html", 
        //		 		 "text/html",
        //				 null);
    }


    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
