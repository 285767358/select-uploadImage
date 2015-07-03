package com.ellemxy.select_uploadimage;

import com.ellemxy.select_uploadimage.ImgManage.ImgUploadListener;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView iv;
	private ImgSelectDialog dialog;
	private ImgManage imgManage;
	private String imgUploadUrl;
	private Boolean isCutImg = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imgManage = new ImgManage(MainActivity.this, imgUploadUrl, isCutImg);
		iv = (ImageView) findViewById(R.id.img);
		dialog = new ImgSelectDialog(MainActivity.this, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
				case ImgSelectDialog.PIC_FROM_CAMERA:
					imgManage.getImg(ImgSelectDialog.PIC_FROM_CAMERA);
					break;

				case ImgSelectDialog.PIC_FROM_LOCALPHOTO:
					imgManage.getImg(ImgSelectDialog.PIC_FROM_LOCALPHOTO);
					break;

				case ImgSelectDialog.CANCEL:
					imgManage.getImg(ImgSelectDialog.PIC_CUT);
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

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case ImgSelectDialog.PIC_FROM_CAMERA:
			imgManage.displayImg(ImgSelectDialog.PIC_FROM_CAMERA, data, iv);
			if (null != imgUploadUrl) {
				imgManage.setImgUploadListener(new ImgUploadListener() {

					@Override
					public void uploadResult(String url) {
						if (null == url) {
							Toast.makeText(MainActivity.this, "ÉÏ´«Ê§°Ü", Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(MainActivity.this, "Í¼Æ¬µØÖ·£º"+url, Toast.LENGTH_SHORT).show();
						}
					}
				});
			}
			break;

		case ImgSelectDialog.PIC_FROM_LOCALPHOTO:
			imgManage.displayImg(ImgSelectDialog.PIC_FROM_LOCALPHOTO, data, iv);
			if (null != imgUploadUrl) {
				imgManage.setImgUploadListener(new ImgUploadListener() {

					@Override
					public void uploadResult(String url) {
						if (null == url) {
							Toast.makeText(MainActivity.this, "ÉÏ´«Ê§°Ü", Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(MainActivity.this, "Í¼Æ¬µØÖ·£º"+url, Toast.LENGTH_SHORT).show();
						}
					}
				});
			}
			break;

		case ImgSelectDialog.PIC_CUT:
			imgManage.displayImg(ImgSelectDialog.PIC_CUT, data, iv);
			if (null != imgUploadUrl) {
				imgManage.setImgUploadListener(new ImgUploadListener() {

					@Override
					public void uploadResult(String url) {
						if (null == url) {
							Toast.makeText(MainActivity.this, "ÉÏ´«Ê§°Ü", Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(MainActivity.this, "Í¼Æ¬µØÖ·£º"+url, Toast.LENGTH_SHORT).show();
						}
					}
				});
			}
			break;
		default:
			break;
		}
	}
}
