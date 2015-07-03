package com.ellemxy.select_uploadimage;

import java.io.File;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

public class BaseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		configurationImageLoader();
	}

	private void configurationImageLoader(){
		File cacheDir = StorageUtils.getOwnCacheDirectory(getApplicationContext(), "wanwu/Cache"); 
		ImageLoaderConfiguration configuration = new ImageLoaderConfiguration  
			    .Builder(this)  
			    .memoryCacheExtraOptions(480, 800) // max width, max height���������ÿ�������ļ�����󳤿�  
			    .threadPoolSize(3)//�̳߳��ڼ��ص�����  
			    .threadPriority(Thread.NORM_PRIORITY - 2)  
			    .denyCacheImageMultipleSizesInMemory()  
			    .memoryCacheSize(2 * 1024 * 1024)    
			    .discCache(new UnlimitedDiscCache(cacheDir))//�Զ��建��·��  
			    .discCacheFileNameGenerator(new Md5FileNameGenerator())
			    .writeDebugLogs() // Remove for release app  
			    .build();//��ʼ���� 
		ImageLoader.getInstance().init(configuration);
	}
}
