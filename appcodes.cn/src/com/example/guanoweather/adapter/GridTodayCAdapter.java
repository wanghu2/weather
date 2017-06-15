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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guanoweather.R;
import com.example.guanoweather.bean.SportIndexBean;

public class GridTodayCAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private List<SportIndexBean> sportIndex;
	private int[] resours = {R.drawable.ic_todaycan_date,  
			R.drawable.ic_todaycan_jingdian, R.drawable.ic_todaycan_dress,
			R.drawable.ic_todaycan_carwash, R.drawable.ic_todaycan_tour,
			R.drawable.ic_todaycan_coldl, R.drawable.ic_todaycan_sport,
			R.drawable.ic_todaycan_ultravioletrays };

	public GridTodayCAdapter(Context context, List<SportIndexBean> sportIndex) {
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
			// 此处需要加上第二个参数parent，否则item中的设置无效。如item高度设置。
			convertView = mInflater.inflate(R.layout.item_gridview_todaycan,
					parent, false);
		}
		TextView dothing = (TextView) convertView.findViewById(R.id.dothing);
		TextView index = (TextView) convertView.findViewById(R.id.index);
		ImageView image_index = (ImageView) convertView
				.findViewById(R.id.image_index);
		ImageView image_click = (ImageView) convertView
				.findViewById(R.id.image_click);

		// 设置数据
		if (position == 0){
			dothing.setText("今天是");
		}else if (position == 1) {
			dothing.setText("城市景点");
		}else if (position == 2){
			dothing.setText("穿衣指数");
		}else if (position == 3) {
			dothing.setText("洗车指数");
		}else if (position == 4) {
			dothing.setText("旅游指数");
		}else if (position == 5) {
			dothing.setText("感冒指数");
		}else if (position == 6) {
			dothing.setText("运动指数");
		}else if (position == 7) {
			dothing.setText("紫外线指数");
		}else {
			dothing.setText(sportIndex.get(position).getTipt());
		}

		try{
			if(sportIndex.get(position).getZs() != null){
				if(position == 0){
					index.setText(sportIndex.get(position +6).getZs());
				}else if(position == 1){
					index.setText(sportIndex.get(position +6).getZs());
				}else {
					index.setText(sportIndex.get(position-2).getZs());
				}
			}else{
				index.setText("暂无");
			}
		}catch(NullPointerException e){
			index.setText("暂无");
		}
		Log.i("TAG", sportIndex.size()+"sportIndex.size()");
		image_index.setBackgroundResource(resours[position]);
		image_click.setBackgroundResource(R.drawable.ic_todaycan_clickbt);
		return convertView;
	}
}
