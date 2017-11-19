package com.dev.rahul.librariesio.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dev.rahul.librariesio.R;
import com.dev.rahul.librariesio.adapter.PlatformsAdapter;
import com.dev.rahul.librariesio.model.Platforms;
import com.dev.rahul.librariesio.ui.about.AboutActivity;
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
		recyclerPlatforms.setLayoutManager(gridLayoutManager);
		recyclerPlatforms.setHasFixedSize(true);

		homePresenter = new HomePresenter(this);
		homePresenter.loadPlatforms();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_home,menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.item_about) {
			startActivity(new Intent(this, AboutActivity.class));
		}
		return super.onOptionsItemSelected(item);
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
