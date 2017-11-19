package com.dev.rahul.librariesio.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.rahul.librariesio.R;
import com.dev.rahul.librariesio.model.Platforms;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rahul on 12/11/17.
 */

public class PlatformsAdapter extends RecyclerView.Adapter<PlatformsAdapter.PlatformsHolder> {

	List<Platforms> platformsList;
	Context context;
	LayoutInflater layoutInflater;

	public PlatformsAdapter(List<Platforms> platformsList, Context context) {
		this.platformsList = platformsList;
		this.context = context;
		if (context != null)
			layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public PlatformsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new PlatformsHolder(layoutInflater.inflate(R.layout.recycler_platforms,parent,false));
	}

	@Override
	public void onBindViewHolder(PlatformsHolder holder, int position) {
		holder.tvPlatforms.setText(platformsList.get(position).getName());
		holder.tvPlatforms.setBackgroundColor(Color.parseColor(platformsList.get(position).getColor()));
		holder.tvDefaultLanguage.setText(
				Html.fromHtml("default language : <br>"
						+ "<font color='" + platformsList.get(position).getColor() + "'>"
						+ platformsList.get(position).getDefaultLanguage()
						+ "</font>"
				)
		);

		holder.tvHomeLink.setText(platformsList.get(position).getHomePage());
		holder.tvHomeLink.setTextColor(Color.parseColor(platformsList.get(position).getColor()));
		holder.tvProjectsCount.setText(
				Html.fromHtml("Projects : <br>"
						+ "<font color='" + platformsList.get(position).getColor() + "'>"
						+ platformsList.get(position).getProjectsCount()
						+ "</font>"
				)
		);
	}

	@Override
	public int getItemCount() {
		return platformsList != null ? platformsList.size() : 0;
	}

	public class PlatformsHolder extends RecyclerView.ViewHolder {

		@BindView(R.id.tvPlatforms)
		AppCompatTextView tvPlatforms;
		@BindView(R.id.tvDefaultLanguage)
		AppCompatTextView tvDefaultLanguage;
		@BindView(R.id.tvHomeLink)
		AppCompatTextView tvHomeLink;
		@BindView(R.id.tvProjectsCount)
		AppCompatTextView tvProjectsCount;

		public PlatformsHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this,itemView);
		}
	}
}
