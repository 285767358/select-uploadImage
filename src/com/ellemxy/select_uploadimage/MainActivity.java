package com.ellemxy.select_uploadimage;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView iv;
	private ImgSelectDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		iv = (ImageView) findViewById(R.id.img);
		dialog = new ImgSelectDialog(MainActivity.this, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
				case ImgSelectDialog.PIC_FROM_CAMERA:
					break;

				case ImgSelectDialog.PIC_FROM_LOCALPHOTO:
					break;

				case ImgSelectDialog.CANCEL:
					break;

				default:
					break;
				}
			}
		});

		iv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dialog.Create();
			}
		});
	}
}
