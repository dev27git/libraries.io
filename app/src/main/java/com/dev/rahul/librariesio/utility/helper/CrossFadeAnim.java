package com.dev.rahul.librariesio.utility.helper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;

/**
 * Created by rahul on 12/11/17.
 */

public class CrossFadeAnim {
	public static void crossfade(View mContentView, final View mLoadingView, Context context) {

		int mShortAnimationDuration = context.getResources().getInteger(android.R.integer.config_shortAnimTime);
		// Set the content view to 0% opacity but visible, so that it is visible
		// (but fully transparent) during the animation.
		mContentView.setAlpha(0f);
		mContentView.setVisibility(View.VISIBLE);

		// Animate the content view to 100% opacity, and clear any animation
		// listener set on the view.
		mContentView.animate()
				.alpha(1f)
				.setDuration(mShortAnimationDuration)
				.setListener(null);

		// Animate the loading view to 0% opacity. After the animation ends,
		// set its visibility to GONE as an optimization step (it won't
		// participate in layout passes, etc.)
		mLoadingView.animate()
				.alpha(0f)
				.setDuration(mShortAnimationDuration)
				.setListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						mLoadingView.setVisibility(View.GONE);
					}
				});
	}
}
