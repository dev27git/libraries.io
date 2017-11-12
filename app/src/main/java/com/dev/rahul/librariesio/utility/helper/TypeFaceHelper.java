package com.dev.rahul.librariesio.utility.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by rahul on 11/11/17.
 */

public class TypeFaceHelper {

	private static Typeface logoTypeface = null;
	private static Typeface regularTypeface = null;

	public static void setLogoTypeface(Context context, TextView textview){
		if(logoTypeface == null){
			logoTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Lobster_Regular.ttf");
		}
		textview.setTypeface(logoTypeface);
	}

	public static void setRegularTypeface(Context context, TextView textview){
		if(regularTypeface == null){
			regularTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans_Regular.ttf");
		}
		textview.setTypeface(regularTypeface);
	}
}
