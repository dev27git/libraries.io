package com.dev.rahul.librariesio.ui.home;

import com.dev.rahul.librariesio.model.Platforms;

import java.util.List;

/**
 * Created by rahul on 11/11/17.
 */

public class HomePresenter implements IHomePresenter{

	private IHomeView homeView;
	private IHomeRepository homeRepository;

	public HomePresenter(IHomeView homeView) {
		this.homeView = homeView;
		this.homeRepository = new HomeRepository();
	}

	@Override
	public void loadPlatforms() {
		homeView.showProgress();
		homeRepository.fetchPlatformsList(new IHomeRepository.OnLoadFinishedListener() {
			@Override
			public void onError(String error) {
				homeView.hideProgress();
				homeView.showError(error);
			}

			@Override
			public void onSuccess(List<Platforms> list) {
				homeView.hideProgress();
				homeView.showData(list);
			}

			@Override
			public void onFailed(String message) {
				homeView.hideProgress();
				homeView.showError(message);
			}
		});
	}

	@Override
	public void onDestroy() {
		homeRepository.cancelRequest();
		homeView = null;
	}
}
