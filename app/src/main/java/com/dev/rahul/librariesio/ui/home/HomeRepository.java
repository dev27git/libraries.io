package com.dev.rahul.librariesio.ui.home;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dev.rahul.librariesio.application.YoLibraries;
import com.dev.rahul.librariesio.model.Platforms;
import com.dev.rahul.librariesio.utility.credentials.API;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 11/11/17.
 */

public class HomeRepository implements IHomeRepository {

	private static final String TAG = HomeRepository.class.getSimpleName();

	@Override
	public void fetchPlatformsList(final OnLoadFinishedListener onLoadFinishedListener) {
		StringRequest stringRequest = new StringRequest(
				Request.Method.GET,
				API.platforms(),
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						try {
							JSONArray jsonArray = new JSONArray(response);
							List<Platforms> platforms = getPlatformsList(jsonArray);
							if (platforms.isEmpty())
								onLoadFinishedListener.onFailed("server returned empty list");
							else
								onLoadFinishedListener.onSuccess(platforms);
						} catch (JSONException e) {
							onLoadFinishedListener.onFailed(e.getMessage());
							e.printStackTrace();
						}
					}
				},
				new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						if (error != null && error.getMessage() != null)
							onLoadFinishedListener.onError(error.getMessage());
					}
				}
		);
		stringRequest.setTag(TAG);
		YoLibraries.getVolley().add(stringRequest);
	}

	@Override
	public List<Platforms> getPlatformsList(JSONArray jsonArray) throws JSONException {
		List<Platforms> platformsList = new ArrayList<>();

		for (int i = 0 ; i < jsonArray.length() ; i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);

			Platforms platforms = new Platforms();
			platforms.setName(jsonObject.getString("name"));
			platforms.setColor(jsonObject.getString("color"));
			platforms.setProjectsCount(jsonObject.getString("project_count"));
			platforms.setDefaultLanguage(jsonObject.getString("default_language"));
			platforms.setHomePage(jsonObject.getString("homepage"));

			platformsList.add(platforms);
		}

		return platformsList;
	}

	@Override
	public void cancelRequest() {
		YoLibraries.getVolley().cancelAll(TAG);
	}
}
