package com.example.getcomments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
	private static final String tag = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		Log.i(tag, "onCreate");
	}
	public void mainActivityButtons(View view) {
		int buttonId = view.getId();
		if (R.id.show_comment_form == buttonId) {
			Log.i(tag, "show_comment_form");
			startActivity(new Intent(this, CommentsActivity.class));
		}
	}
}
