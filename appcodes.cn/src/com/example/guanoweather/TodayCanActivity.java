/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package com.example.guanoweather;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class TodayCanActivity extends Activity implements OnClickListener{

	private TextView bottom_todaycan;//
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.todaycan_activity);
		
		initView();
		setdata();
	}

	private void initView() {
		bottom_todaycan = (TextView) findViewById(R.id.bottom_todaycan);
	}
	
	@Override
	protected void onResume() {
		bottom_todaycan.setBackgroundColor(Color.parseColor(getString(R.string.color_bottombg)));
		super.onResume();
	}
	
	private void setdata() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bottom_citymanager:
			intent = new Intent(this, CityManagerActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.bottom_weathertext:
			finish();
			break;
		}
	}
}
