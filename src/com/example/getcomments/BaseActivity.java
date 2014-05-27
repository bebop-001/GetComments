package com.example.getcomments;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class BaseActivity extends FragmentActivity {
	private static Menu menu;
    private static final String tag = "FragmentActivity";
    // if user checked a checkbox, turn the other one off and
    // return true.  if NoImage is selected, 
    static class SelectedImage {
    	private static int currentSelected = 0;
    	static void check(MenuItem item) {
    		int id = item.getItemId();
    		MenuItem item_1, item_2;
    		item_1 = menu.findItem(R.id.image_1);
    		item_2 = menu.findItem(R.id.image_2);
    		if (item.isChecked()) {
    			// if user turned off an image, just turn off all images
    				item_1.setChecked(false);
    				item_2.setChecked(false);
    				currentSelected = 0;
    		}
			else {
				// an image was selected.  Turn it on and the other
				// image off.
				item.setChecked(true);
				if (id == R.id.image_1) item_2.setChecked(false);
				else item_1.setChecked(false);
				currentSelected = id;
			}
    	}
    	static void set(int selected) {
    		currentSelected = selected;
    	}
    	static int get () { return currentSelected; }
    }
	
	// Default menu.  Unless a class implements its own onCreateOptionsMenu
	// method, it gets menu items defined in the menu/base_activity
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.base_activity, menu);
		BaseActivity.menu = menu;
		return true;
	}
	// Default menu handler.  As long as a menu item has an ID here, it
	// gets handled here.
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String title = (item.getTitle() == null)
				? "-- NO TITLE --"
				: item.getTitle().toString();
        Log.i(tag, "onOptionsItemSelected:" + title);
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
            case R.id.action_settings:
            	// Track and set state so orientation change doesn't 
            	// wipe out the selections.
            	int selected = SelectedImage.get();
            	Log.i(tag, String.format("selected:item 0x%8x", selected));
            	if (selected > 0) {
            		MenuItem i = menu.findItem(selected);
            		i.setChecked(true);
            	}
            	break;
            case R.id.image_1:
            case R.id.image_2:
            	SelectedImage.check(item);
            	Log.i(tag, "select image");
            	break;
            default:
                // Currently nested menu items aren't caught in switch above
            	// and show up here.
                Log.i(tag, "menu.default:"
                    + "Title = \"" + title
                    + String.format("\": id = 0x%08x:", item.getItemId())
                    + " not in switch");
                return super.onOptionsItemSelected(item);
		}
        return true;
	}
}
