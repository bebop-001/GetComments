package com.example.getcomments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CommentsActivity extends FragmentActivity {
	private static final String tag = "CommentsActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(tag, "onCreate");
		setContentView(R.layout.comments_fragment);
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
