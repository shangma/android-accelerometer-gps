package com.szlosek.whenmoving;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;


public class MainItemizedOverlay extends ItemizedOverlay {
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	Context myContext;

	public MainItemizedOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
		myContext = MainActivity.myContext;
		populate();
	}

	public MainItemizedOverlay(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		populate();
		myContext = context;
	}

	public void clear() {
		mOverlays.clear();
	}

	public void addOverlay(OverlayItem overlay) {
		mOverlays.add(overlay);
		populate();
	}

	@Override
	protected OverlayItem createItem(int i) {
		return mOverlays.get(i);
	}

	@Override
	public int size() {
		return mOverlays.size();
	}


	@Override
	protected boolean onTap(int index) {
		OverlayItem item = mOverlays.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(myContext);
		dialog.setTitle("title"); //item.getTitle());
		dialog.setMessage("message"); //item.getSnippet());
		dialog.show();
		return true;
	}
}