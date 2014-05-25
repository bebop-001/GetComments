package com.example.getcomments;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CommentsActivity extends Activity {
	private static final String tag = "CommentsActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comments_layout);
		Log.i(tag, "onCreate");
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
}
