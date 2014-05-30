package com.example.getcomments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CommentsFragment extends Fragment {
    public static final String tag = "CommentsFragment";
    private View commentView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
        Log.i(tag, "onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        Log.i(tag, "onCreateView");
        commentView = inflater
        		.inflate(R.layout.comments_layout, container, false);
        ((Button)commentView.findViewById(R.id.submit_comment))
        	.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					CommentActivityButtons(v, commentView);
				}
        	}
    	);
		return commentView;
	}
  	CommentButtonListener commentCallback;
	public interface CommentButtonListener {
		public void commentButtonListener(
				String name, String email, String comment);
	}
	public void onAttach(Activity activity) {
		Log.i(tag, "onAttach version:" + activity.toString());
		try {
			commentCallback = (CommentButtonListener) activity;
			Log.i(tag, "onAttach: got mainButtonCallback");
		}
		catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
				+ ":Must implement CommentButtonListener"
			);
		}
		super.onAttach(activity);
	}
	public void CommentActivityButtons(View view, View commentView) {
		int buttonId = view.getId();
		if (R.id.submit_comment == buttonId) {
			EditText nameEt, commentEt, emailEt;
			nameEt 			= (EditText)commentView.findViewById(R.id.name);
			emailEt 		= (EditText)commentView.findViewById(R.id.email);
			commentEt 		= (EditText)commentView.findViewById(R.id.comment);
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
			commentCallback.commentButtonListener(name, email, comment);
		}
		else {
			Log.i(tag, "UNKOWN BUTTON:" + buttonId);
		}
	}

	@Override
	public void onDestroy() {
        Log.i(tag, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
        Log.i(tag, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDetach() {
        Log.i(tag, "onDetach");
		super.onDetach();
	}

	@Override
	public void onPause() {
        Log.i(tag, "onPause");
		super.onPause();
	}

	@Override
	public void onResume() {
        Log.i(tag, "onResume");
		super.onResume();
	}

	@Override
	public void onStart() {
        Log.i(tag, "onStart");
		super.onStart();
	}

	@Override
	public void onStop() {
        Log.i(tag, "onStop");
		super.onStop();
	}

}
