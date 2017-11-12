package com.dev.rahul.librariesio.utility.widgets.text_view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.dev.rahul.librariesio.utility.helper.TypeFaceHelper;

/**
 * Created by rahul on 12/11/17.
 */

public class RegularTextView extends AppCompatTextView {
	public RegularTextView(Context context) {
		super(context);
		TypeFaceHelper.setRegularTypeface(context,this);
	}

	public RegularTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypeFaceHelper.setRegularTypeface(context,this);
	}

	public RegularTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		TypeFaceHelper.setRegularTypeface(context,this);
	}
}
