/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package com.example.guanoweather.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.guanoweather.R;
import com.example.guanoweather.bean.SportIndexBean;

public class GridAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private List<SportIndexBean> sportIndex;

	public GridAdapter(Context context, List<SportIndexBean> sportIndex) {
		this.mInflater = LayoutInflater.from(context);
		this.sportIndex = sportIndex;
	}

	@Override
	public int getCount() {
		return sportIndex == null ? 0 : sportIndex.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_gridview_todaycan,
					parent, false);//此处需要加上第二个参数parent，否则item中的设置无效。如item高度设置。
		}
		TextView dothing = (TextView) convertView.findViewById(R.id.dothing);
		TextView index = (TextView) convertView.findViewById(R.id.index);
		//设置数据
		dothing.setText(sportIndex.get(position).getTipt());
		index.setText(sportIndex.get(position).getZs());
		return convertView;
	}
	
	/**
	 * 屏蔽item的点击事件
	 */
	@Override
	public boolean isEnabled(int position) {
		return false;
	}
}
