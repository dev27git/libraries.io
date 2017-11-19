package com.dev.rahul.librariesio.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dev.rahul.librariesio.R;
import com.dev.rahul.librariesio.model.GitProfile;
import com.dev.rahul.librariesio.utility.helper.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class AboutActivity extends AppCompatActivity implements IAboutView,IAboutView.navigation{

	private static final String TAG = AboutActivity.class.getSimpleName();

	@BindView(R.id.includeLoading)
	View includeLoading;
	@BindView(R.id.imgProfile)
	CircleImageView imgProfile;
	@BindView(R.id.tvGitUsername)
	AppCompatTextView tvGitUsername;
	@BindView(R.id.tvName)
	AppCompatTextView tvName;
	@BindView(R.id.tvBio)
	AppCompatTextView tvBio;
	@BindView(R.id.tvCompany)
	AppCompatTextView tvCompany;
	@BindView(R.id.tvRepos)
	AppCompatTextView tvRepos;
	@BindView(R.id.tvGists)
	AppCompatTextView tvGists;
	@BindView(R.id.tvFollowers)
	AppCompatTextView tvFollowers;
	@BindView(R.id.tvFollowings)
	AppCompatTextView tvFollowings;

	private AboutPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		ButterKnife.bind(this);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		includeLoading.findViewById(R.id.tvProgressText).setVisibility(View.GONE);
		presenter = new AboutPresenter(this,this);
		presenter.loadData();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home)
			onBackPressed();

		return super.onOptionsItemSelected(item);
	}

	@OnClick(R.id.imgProfile)
	public void showProfileDetails() {
		presenter.showUrlOptions();
	}

	@Override
	public void showProgress() {
		includeLoading.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideProgress() {
		includeLoading.setVisibility(View.GONE);
	}

	@Override
	public void showError(String error) {
		Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showData(final GitProfile profile) {
		tvBio.setText(profile.getBio());
		tvCompany.setText(profile.getCompany());
		tvFollowers.setText(profile.getFollowers());
		tvFollowings.setText(profile.getFollowings());
		tvGists.setText(profile.getPublicGists());
		tvGitUsername.setText(profile.getLogin());
		tvName.setText(profile.getName());
		tvRepos.setText(profile.getPublicRepos());
		new ImageLoader(imgProfile,profile.getAvatarUrl()).execute();
	}

	@Override
	protected void onDestroy() {
		presenter.onDestroy();
		super.onDestroy();
	}

	@Override
	public void openUrl(String url) {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		startActivity(intent);
	}
}
