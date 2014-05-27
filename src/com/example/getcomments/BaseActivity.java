package com.example.getcomments;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class BaseActivity extends FragmentActivity {
	private static Menu menu;
    private static final String tag = "FragmentActivity";
    // allow user to select only one of N items.  Save selected
    // item id for use in orientation change, restart, etc...
    static class SelectedImage {
    	private static int currentSelected = 0;
    	static void check(MenuItem item) {
    		boolean isChecked = item.isChecked();
    		int[] itemIds = {R.id.image_1, R.id.image_2, R.id.comments_frag};
    		// unselect all
			currentSelected = 0;
    		for (int itemId : itemIds)
				((MenuItem)menu.findItem(itemId)).setChecked(false);
    		// if Item is to be selected, select it
    		if (isChecked == false) {
				item.setChecked(true);
				currentSelected = item.getItemId();;
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
            case R.id.comments_frag:
            case R.id.image_1:
            case R.id.image_2:
            	SelectedImage.check(item);
            	Log.i(tag, "select image" + title);
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
