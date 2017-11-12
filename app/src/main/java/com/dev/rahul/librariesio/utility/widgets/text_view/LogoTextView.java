package com.dev.rahul.librariesio.utility.widgets.text_view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.dev.rahul.librariesio.utility.helper.TypeFaceHelper;

/**
 * Created by rahul on 11/11/17.
 */

public class LogoTextView extends AppCompatTextView {
	public LogoTextView(Context context) {
		super(context);
		TypeFaceHelper.setLogoTypeface(context,this);
	}

	public LogoTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypeFaceHelper.setLogoTypeface(context,this);
	}

	public LogoTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		TypeFaceHelper.setLogoTypeface(context,this);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}
}
