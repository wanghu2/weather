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
import android.widget.TextView;

import com.example.guanoweather.R;
import com.example.guanoweather.base.CHImageView;
import com.example.guanoweather.bean.WeatherSubBean;

public class ListAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private List<WeatherSubBean> tweather;

	public ListAdapter(Context context, List<WeatherSubBean> tweather) {
		this.mInflater = LayoutInflater.from(context);
		this.tweather = tweather;
	}

	@Override
	public int getCount() {
		return tweather == null ? 0 : tweather.size();
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
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_listview_tomorrow,
					null);
		}
		// 日期
		TextView list_date_nextday = (TextView) convertView
				.findViewById(R.id.list_date_nextday);
		if (position > 0) {
			list_date_nextday.setText(tweather.get(position).getDate());
		} else if (position == 0) {
			list_date_nextday.setText("今天");
		} 

		// 白天天气图片
		CHImageView list_day_picture = (CHImageView) convertView
				.findViewById(R.id.list_day_picture);
		String dayp = tweather.get(position).getDayPictureUrl();
		list_day_picture.loadImage(dayp);
		
		// 夜晚天气图片
		CHImageView list_night_picture = (CHImageView) convertView
				.findViewById(R.id.list_night_picture);
		String nightp = tweather.get(position).getNightPictureUrl();
		list_night_picture.loadImage(nightp);

		// 天气情况
		TextView list_weather = (TextView) convertView
				.findViewById(R.id.list_weather);
		list_weather.setText(tweather.get(position).getWeather());
		// 温度
		TextView list_temperature = (TextView) convertView
				.findViewById(R.id.list_temperature);
		String str = tweather.get(position).getTemperature();
		if(str.length() > 4){
			//默认将最低温度显示在前面的算法
			String str1 = str.substring(0, str.length()-1);
			String str2 = str.substring(str.length()-1, str.length());
			Log.i("TAG", str2);
			String [] mstr = str1.split("~", 2);
			list_temperature.setText(mstr[1]+" ~ "+mstr[0]+str2);
		}else{
			list_temperature.setText(str);
		}
		
		// 风力
		TextView list_wind = (TextView) convertView
				.findViewById(R.id.list_wind);
		list_wind.setText(tweather.get(position).getWind());

		return convertView;
	}

//	/**
//	 * 将InputStream转换为Bitmap
//	 * 
//	 * @param mhe
//	 */
//	private Bitmap inputstreamTbitmap(MHttpEntity mhe) {
//		Bitmap bt = null;
//		try {
//			if (mhe.getHentity() != null) {
//				InputStream is = mhe.getHentity().getContent();
//				bt = BitmapFactory.decodeStream(is);
//			}
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return bt;
//	}

	/**
	 * 屏蔽item的点击事件
	 */
	@Override
	public boolean isEnabled(int position) {
		return false;
	}

}
