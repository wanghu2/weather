/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package com.example.guanoweather;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.guanoweather.adapter.GridCityMAdapter;
import com.example.guanoweather.bean.CityManagerBean;

public class CityManagerActivity extends Activity {

	private GridView mgridview;
	private List<CityManagerBean> mcmb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview_activity);
		mcmb = new ArrayList<CityManagerBean>();
//		CityManagerBean F = FragmentHomeContent.cmb;
//		mcmb.add(F);
		mgridview = (GridView) findViewById(R.id.gridview);
		mgridview.setNumColumns(3);
		mgridview.setBackgroundResource(R.drawable.bg_homepager_blur);
		mgridview.setAdapter(new GridCityMAdapter(this, mcmb));
	}
}
