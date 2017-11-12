package com.dev.rahul.librariesio.ui.home;

import com.dev.rahul.librariesio.model.Platforms;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

/**
 * Created by rahul on 11/11/17.
 */

public interface IHomeRepository {

	interface OnLoadFinishedListener {
		void onError(String error);
		void onSuccess(List<Platforms> list);
		void onFailed(String message);
	}

	void fetchPlatformsList(OnLoadFinishedListener onLoadFinishedListener);
	List<Platforms> getPlatformsList(JSONArray jsonArray) throws JSONException;
	void cancelRequest();
}
