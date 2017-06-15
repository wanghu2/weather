/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package com.example.guanoweather.base;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class AutoLocation extends Service implements LocationListener{

	private LocationManager locationmanager;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		locationmanager = (LocationManager) getSystemService(LOCATION_SERVICE);
	}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(locationmanager.getProvider(LocationManager.NETWORK_PROVIDER) != null){
			locationmanager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
		}else if(locationmanager.getProvider(LocationManager.GPS_PROVIDER) != null){
			locationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
		}else{
			Toast.makeText(this, "无法定位", Toast.LENGTH_SHORT).show();
		}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public boolean stopService(Intent name) {
		return super.stopService(name);
	}

	@Override
	public void onLocationChanged(Location location) {
		//通知Activity
		Intent intent = new Intent();
		intent.setAction("locationAction");
		intent.putExtra("location", location.toString());
		sendBroadcast(intent);
		//移除监听，停止服务
		locationmanager.removeUpdates(this);
		stopSelf();
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		
	}
	
}
