package com.dev.rahul.librariesio.ui.about;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dev.rahul.librariesio.application.YoLibraries;
import com.dev.rahul.librariesio.model.GitProfile;
import com.dev.rahul.librariesio.utility.credentials.Constants;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rahul on 18/11/17.
 */

public class AboutRepository implements IAboutRepository{

	private static final String TAG = AboutRepository.class.getSimpleName();
	private static final String GITHUB_PROFILE_API = "https://api.github.com/users/"+ Constants.GITHUB_USERNAME;
	private GitProfile gitProfile = null;

	@Override
	public void fetchData(final OnLoadFinishedListener listener) {
		StringRequest stringRequest = new StringRequest(
				Request.Method.GET,
				GITHUB_PROFILE_API,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						Log.i(TAG,response);
						try {
							JSONObject jsonObject = new JSONObject(response);
							listener.onSuccess(parseData(jsonObject));
						} catch (JSONException e) {
							listener.onFailed(e.getMessage());
							e.printStackTrace();
						}
					}
				},
				new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						if (error != null && error.getMessage() != null)
							listener.onError(error.getMessage());
					}
				}
		);
		stringRequest.setTag(TAG);
		YoLibraries.getVolley().add(stringRequest);
	}

	@Override
	public String getProfileUrl() {
		if (gitProfile == null)
			return "";

		return gitProfile.getHtmlUrl();
	}

	public GitProfile parseData(JSONObject jsonObject) throws JSONException {

		gitProfile = new GitProfile();
		gitProfile.setAvatarUrl(jsonObject.getString("avatar_url"));
		gitProfile.setBio(jsonObject.getString("bio"));
		gitProfile.setCompany(jsonObject.getString("company"));
		gitProfile.setFollowers(jsonObject.getString("followers"));
		gitProfile.setFollowings(jsonObject.getString("following"));
		gitProfile.setHtmlUrl(jsonObject.getString("html_url"));
		gitProfile.setLocation(jsonObject.getString("location"));
		gitProfile.setLogin(jsonObject.getString("login"));
		gitProfile.setName(jsonObject.getString("name"));
		gitProfile.setPublicGists(jsonObject.getString("public_gists"));
		gitProfile.setPublicRepos(jsonObject.getString("public_repos"));
		return gitProfile;
	}

	@Override
	public void cancelRequest() {
		YoLibraries.getVolley().cancelAll(TAG);
	}
}
