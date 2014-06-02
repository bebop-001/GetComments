package com.example.getcomments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PictureFrag_1 extends Fragment {
	private static final String tag = "PictureFrag_1";
    private static View pic_view;
    Fragment commentsFrag;
    

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(tag, "onCreateView:container:" + ((container == null) ? "NULL" : container.toString()));
		pic_view = inflater.inflate(R.layout.picture_layout_1, container, false);
		return pic_view;
		// return super.onCreateView(inflater, container, savedInstanceState);
	}
}
