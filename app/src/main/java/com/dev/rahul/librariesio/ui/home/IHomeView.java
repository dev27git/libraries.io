package com.dev.rahul.librariesio.ui.home;

import com.dev.rahul.librariesio.model.Platforms;

import java.util.List;

/**
 * Created by rahul on 11/11/17.
 */

public interface IHomeView {

	void showProgress();
	void hideProgress();
	void showError(String error);
	void showData(List<Platforms> platformsList);
}
