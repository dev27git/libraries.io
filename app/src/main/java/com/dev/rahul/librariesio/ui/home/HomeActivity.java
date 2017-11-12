package com.dev.rahul.librariesio.ui.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.dev.rahul.librariesio.R;
import com.dev.rahul.librariesio.adapter.PlatformsAdapter;
import com.dev.rahul.librariesio.model.Platforms;
import com.dev.rahul.librariesio.utility.helper.CrossFadeAnim;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements IHomeView {

	@BindView(R.id.recyclerPlatforms)
	RecyclerView recyclerPlatforms;
	@BindView(R.id.includeLoading)
	View includeLoading;

	private HomePresenter homePresenter;
	private PlatformsAdapter platformsAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		ButterKnife.bind(this);

		GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
		StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
		recyclerPlatforms.setLayoutManager(staggeredGridLayoutManager);
		recyclerPlatforms.setHasFixedSize(true);

		homePresenter = new HomePresenter(this);
		homePresenter.loadPlatforms();
	}

	@Override
	public void showProgress() {
		recyclerPlatforms.setVisibility(View.GONE);
		includeLoading.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideProgress() {
		CrossFadeAnim.crossfade(recyclerPlatforms,includeLoading,this);
	}

	@Override
	public void showError(String error) {
		includeLoading.setVisibility(View.GONE);
		Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showData(List<Platforms> platformsList) {
		platformsAdapter = new PlatformsAdapter(platformsList,this);
		recyclerPlatforms.setAdapter(platformsAdapter);
	}

	@Override
	protected void onDestroy() {
		homePresenter.onDestroy();
		super.onDestroy();
	}
}
