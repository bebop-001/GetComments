package com.example.getcomments;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.getcomments.CommentsFragment.CommentListener;

public class MainActivity extends BaseActivity implements CommentListener {
	private static final String tag = "MainActivity";
	// Need class fragManager and placeholder elements because menu calls
	// are from the BaseActivity so context changes.  This works because
	// all items happen on thread 1 (the UI thread) and the MainActivity
	// is visible (active) whenever the BaseActivity is alive.
    private static FragmentManager fragManager;
	private static TextView placeholder = null;

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
    // Listener for results of user pressing the comment submit button.
	@Override
	public void commentListener(String name, String email, String comment) {
		Log.i(tag, "commentListener:"
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
        // On startup the placeholder has no fragment displayed.
        // put text saying "Placeholder" to show where it is.
		placeholder = (TextView) findViewById(R.id.placeholder);
		placeholder.setText("Placeholder");
        fragManager = getSupportFragmentManager();
		super.onStart();
	}
	@Override
	protected void onStop() {
        Log.i(tag, "onStop");
        fragManager = null;
        placeholder = null;
		super.onStop();
	}
	@Override
	public void onOptionsMenuClosed(Menu menu) {
		Log.i(tag, "onOptionsMenuClosed");
		super.onOptionsMenuClosed(menu);
	}
	private static int currentFragId = 0;
	protected static void showFragment(int fragId) {
		Fragment frag = null;
		if (currentFragId != fragId) {
			// no fragment -- show textview that says
			// Placeholder to show where the placeholder
			// frame is.
			if (fragId == 0) {
				if (placeholder != null)
					placeholder.setText("Placeholder");
			}
			else {
				if (placeholder != null)
					placeholder.setText("");
				if (fragId == 1) {
					frag = new PictureFrag_1();
				}
				else if (fragId == 2) {
					frag = new PictureFrag_2();
				}
				else if (fragId == 3) {
					frag = new CommentsFragment();
				}
				else Log.wtf(tag, "showFragment: non valid id: " + fragId);
			}
		}
		if (frag != null || fragId == 0) {
			currentFragId = fragId;
			// FragmentManager.enableDebugLogging(true);
	        Log.i(tag,">>" + fragManager.toString());
	        fragManager.executePendingTransactions();
			Fragment current = fragManager.findFragmentById(R.id.frag_placeholder);
	        FragmentTransaction ft = fragManager.beginTransaction();
			if (null != current) {
		        ft.remove(current);
				ft.commit();
			}
			fragManager.executePendingTransactions();
			if (frag != null) {
		        ft = fragManager.beginTransaction();
		        ft.add(R.id.frag_placeholder, frag, "ACTION_IMAGE");
		        ft.commit();
			}
		}
	}
    public void nextFrag(View view) {
        showFragment((currentFragId + 1) % 4);
    }
}
