package com.example.getcomments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;

public class CommentsActivity extends BaseActivity {
	private static final String tag = "CommentsActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(tag, "onCreate");
		setContentView(R.layout.comments_fragment);
	}
    // Give the second activity a unique menu -- different than the menu in
    // the main activity.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comments_activity, menu);
		if (BuildConfig.DEBUG) Log.i(tag, "onCreateOptionsMenu");
		return true;
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
        Log.i(tag, "onConfigurationChanged");
		super.onConfigurationChanged(newConfig);
	}
	@Override
	protected void onDestroy() {
        Log.i(tag, "onDestroy");
        // For this activity, onDestroy typically means orientation 
        // change.  Finish the activity.
        finish();  
		super.onDestroy();
	}
	@Override
	protected void onPause() {
        Log.i(tag, "onPause");
		super.onPause();
	}
	@Override
	protected void onResume() {
        Log.i(tag, "onResume");
		super.onResume();
	}
	@Override
	protected void onStart() {
        Log.i(tag, "onStart");
		super.onStart();
	}
	@Override
	protected void onStop() {
        Log.i(tag, "onStop");
		super.onStop();
	}
}
