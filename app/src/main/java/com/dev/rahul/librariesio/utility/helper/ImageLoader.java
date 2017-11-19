package com.dev.rahul.librariesio.utility.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by rahul on 19/11/17.
 */

public class ImageLoader extends AsyncTask<Void,Void,Void> {
	private CircleImageView imageView;
	private String imageUrl = "";

	public ImageLoader(CircleImageView imageView, String imageUrl) {
		this.imageView = imageView;
		this.imageUrl = imageUrl;
	}

	@Override
	protected Void doInBackground(Void... voids) {
		try {
			URL url = new URL(imageUrl);
			final Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
			imageView.post(new Runnable() {
				@Override
				public void run() {
					imageView.setImageBitmap(bitmap);
					bitmap.recycle();
				}
			});
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
