package com.example.mini_projet_android;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class ShowImageActivity extends Activity{
	
	ImageView image;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_image);
		
		String imageUrl =  getIntent().getStringExtra(Data.urlImage);
		image = (ImageView) findViewById(R.id.imageView1);
		Picasso.with(this)
			.load(imageUrl)
		.into(image);
		
	}
	
}
