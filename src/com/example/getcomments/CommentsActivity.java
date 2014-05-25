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
	public void CommentActivityButtons(View view) {
		int buttonId = view.getId();
		if (R.id.submit_comment == buttonId) {
			EditText nameEt, commentEt, emailEt;
			nameEt 			= (EditText)findViewById(R.id.name);
			emailEt 		= (EditText)findViewById(R.id.email);
			commentEt 		= (EditText)findViewById(R.id.comment);
			String name 	= nameEt.getText().toString();
			String comment 	= commentEt.getText().toString();
			String email 	= emailEt.getText().toString();
			nameEt.setText("");
			emailEt.setText("");
			commentEt.setText("");
			Log.i(tag, "show_comment_form:"
				+ "name = \"" 		+ name
				+ "\", email = \"" 	+ email
				+ "\", comment = \"" 	+ comment
				+ "\""
					);
		}
		else {
			Log.i(tag, "UNKOWN BUTTON:" + buttonId);
		}
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
