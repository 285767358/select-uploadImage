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
			    .memoryCacheExtraOptions(480, 800) // max width, max height，即保存的每个缓存文件的最大长宽  
			    .threadPoolSize(3)//线程池内加载的数量  
			    .threadPriority(Thread.NORM_PRIORITY - 2)  
			    .denyCacheImageMultipleSizesInMemory()  
			    .memoryCacheSize(2 * 1024 * 1024)    
			    .discCache(new UnlimitedDiscCache(cacheDir))//自定义缓存路径  
			    .discCacheFileNameGenerator(new Md5FileNameGenerator())
			    .writeDebugLogs() // Remove for release app  
			    .build();//开始构建 
		ImageLoader.getInstance().init(configuration);
	}
}
