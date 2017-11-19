package com.dev.rahul.librariesio.ui.about;

import com.dev.rahul.librariesio.model.GitProfile;

/**
 * Created by rahul on 18/11/17.
 */

public interface IAboutRepository {

	interface OnLoadFinishedListener {
		void onError(String error);
		void onSuccess(GitProfile profile);
		void onFailed(String message);
	}

	void fetchData(OnLoadFinishedListener listener);
	String getProfileUrl();
	void cancelRequest();
}
