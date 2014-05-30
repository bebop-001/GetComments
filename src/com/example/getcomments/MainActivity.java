package com.example.getcomments;

import com.example.getcomments.CommentsFragment.CommentButtonListener;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends BaseActivity implements CommentButtonListener {
	private static final String tag = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(tag, "onCreate");
		setContentView(R.layout.main_layout);
	}
	public void mainActivityButtons(View view) {
		int buttonId = view.getId();
		if (R.id.show_comment_form == buttonId) {
			Log.i(tag, "show_comment_form");
			startActivity(new Intent(this, CommentsActivity.class));
		}
	}
	// callback from the comment fragment.
	@Override
	public void commentButtonListener(String name, String email, String comment) {
		Log.i(tag, "commentButtonListener:"
			+ "name:\"" + name + "\""
			+ "email:\"" + email + "\""
			+ "comment:\"" + comment + "\""
		);
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
        Log.i(tag, "onConfigurationChanged");
		super.onConfigurationChanged(newConfig);
	}
	@Override
	protected void onDestroy() {
        Log.i(tag, "onDestroy");
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
