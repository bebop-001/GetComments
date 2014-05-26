package com.example.getcomments;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class BaseActivity extends FragmentActivity {
    private static final String tag = "FragmentActivity";
	
	// Default menu.  Unless a class implements its own onCreateOptionsMenu
	// method, it gets menu items defined in the menu/base_activity
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.base_activity, menu);
		return true;
	}
	// Default menu handler.  As long as a menu item has an ID here, it
	// gets handled here.
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(tag, "onOptionsItemSelected:" + item.toString());
		switch(item.getItemId()) {
            case R.id.twitter:
                Log.i(tag, "menu.twitter");
                break;
            case R.id.facebook:
                Log.i(tag, "menu.facebook");
                break;
            case R.id.refresh:
                Log.i(tag, "menu.refresh");
                break;
            default:
                // Currently nested menu items aren't caught in switch above
            	// and show up here.
                Log.i(tag, "menu.default:"
                    + "Title = \"" + item.getTitle().toString() 
                    + String.format("\": id = 0x%08x:", item.getItemId())
                    + " not in switch");
                return super.onOptionsItemSelected(item);
		}
        return true;
	}
}
