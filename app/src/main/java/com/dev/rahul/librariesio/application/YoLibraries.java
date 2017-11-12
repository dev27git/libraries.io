package com.dev.rahul.librariesio.application;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by rahul on 12/11/17.
 */

public class YoLibraries extends Application {
	public static RequestQueue requestQueue;
	private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
		requestQueue = Volley.newRequestQueue(this);
	}

	private static Context getContext() {
		return context;
	}

	public static RequestQueue getVolley() {
		if (requestQueue == null)
			requestQueue = Volley.newRequestQueue(context);
		return requestQueue;
	}
}
