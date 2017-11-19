package com.dev.rahul.librariesio.ui.about;

import com.dev.rahul.librariesio.model.GitProfile;

/**
 * Created by rahul on 18/11/17.
 */

public interface IAboutView {

	void showProgress();
	void hideProgress();
	void showError(String error);
	void showData(GitProfile profile);

	interface navigation {
		void openUrl(String url);
	}
}
