package com.dev.rahul.librariesio.ui.about;

import com.dev.rahul.librariesio.model.GitProfile;

/**
 * Created by rahul on 18/11/17.
 */

public class AboutPresenter implements IAboutPresenter {

	private IAboutView view;
	private IAboutView.navigation navigation;
	private IAboutRepository repository;

	public AboutPresenter(IAboutView view, IAboutView.navigation navigation) {
		this.view = view;
		this.navigation = navigation;
		this.repository = new AboutRepository();
	}

	@Override
	public void loadData() {
		if (view == null)
			return;

		view.showProgress();

		repository.fetchData(new IAboutRepository.OnLoadFinishedListener() {
			@Override
			public void onError(String error) {
				view.hideProgress();
				view.showError(error);
			}

			@Override
			public void onSuccess(GitProfile profile) {
				view.hideProgress();
				view.showData(profile);
			}

			@Override
			public void onFailed(String message) {
				view.hideProgress();
				view.showError(message);
			}
		});
	}

	@Override
	public void onDestroy() {
		repository.cancelRequest();
		navigation = null;
		view = null;
	}

	@Override
	public void showUrlOptions() {
		navigation.openUrl(repository.getProfileUrl());
	}
}
