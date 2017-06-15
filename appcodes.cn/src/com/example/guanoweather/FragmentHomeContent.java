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
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guanoweather.adapter.ListWeatherAdapter;
import com.example.guanoweather.base.Lunar;
import com.example.guanoweather.bean.CityManagerBean;
import com.example.guanoweather.bean.SQLiteCityManager;

public class FragmentHomeContent extends Fragment {

	public static final String TAG = "HomeContent";
	public static List<CityManagerBean> mcmb = new ArrayList<CityManagerBean>();
	public static TextView currentcity;// 当前城市
	private TextView pm25;// PM值
	private TextView temp;// 温度
	private TextView pollution;// 污染程度
	private TextView todaydate;// 农历
	private ListView tweatherlist;//
	private EditText inputcity;
	private Button sendcity;
	private View homep_content;
	public HomePagerActivity homepa = (HomePagerActivity) getActivity();
	public FragmentAndActivity mactivity;
	static ProgressDialog pDialog;
	public static String lunarStr = "";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		HomePagerActivity.TAG_H = TAG;
		homep_content = inflater.inflate(R.layout.include_content_activity,
				null);
		initview();
		setpagedata();
		Log.e("TAG", "setpagedata======>>>>");
		return homep_content;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mactivity = (FragmentAndActivity) activity;

	}

	private void initview() {
		currentcity = (TextView) homep_content.findViewById(R.id.currentcity);
		pm25 = (TextView) homep_content.findViewById(R.id.pm25);
		temp = (TextView) homep_content.findViewById(R.id.temp);
		sendcity = (Button) homep_content.findViewById(R.id.sendcity);
		Log.i("TAG", temp + " <-- temp-->1111111");
		pollution = (TextView) homep_content.findViewById(R.id.pollution_level);
		inputcity = (EditText) homep_content.findViewById(R.id.inputcity);
		tweatherlist = (ListView) homep_content
				.findViewById(R.id.tomorrow_weather);
		todaydate = (TextView) homep_content.findViewById(R.id.today_date_dec);
	}

	public void setpagedata() {
		if(pDialog != null){
			pDialog.dismiss();
		}
		Log.i("TAG", tweatherlist + "-->tweatherlist");
		tweatherlist.setAdapter(new ListWeatherAdapter(getActivity(),
				HomePagerActivity.response.getResults().get(0)
						.getWeather_data()));
		sendcity.setOnClickListener(sendcityonclick);
		currentcity.setText(HomePagerActivity.response.getResults().get(0)
				.getCurrentCity());

		if ("".equals(HomePagerActivity.response.getResults().get(0).getPm25())) {
			pm25.setText("PM2.5：");
			pollution.setText(R.string.no_data);
			pollution.setBackgroundColor(Color.TRANSPARENT);
		} else {
			pm25.setText("PM2.5："
					+ HomePagerActivity.response.getResults().get(0).getPm25());
			int pm = Integer.parseInt(HomePagerActivity.response.getResults()
					.get(0).getPm25());
			Log.i("TAG", pm + " <-- pm");
			if (pm < 75) {
				pollution.setText(R.string.pollution_no);
				pollution.setBackgroundResource(R.drawable.ic_dl_b);
			} else if (pm > 75 && pm < 100) {
				pollution.setText(R.string.pollution_little);
				pollution.setBackgroundResource(R.drawable.ic_dl_c);
			} else if (pm > 100 && pm < 150) {
				pollution.setText(R.string.pollution_mild);
				pollution.setBackgroundResource(R.drawable.ic_dl_d);
			} else if (pm > 150 && pm < 200) {
				pollution.setText(R.string.polltion_moderate);
				pollution.setBackgroundResource(R.drawable.ic_dl_e);
			} else if (pm > 200) {
				pollution.setText(R.string.polltion_severe);
				pollution.setBackgroundResource(R.drawable.ic_dl_f);
			}
		}
		Calendar cal = Calendar.getInstance();
		// 获取系统年月日
		// int date = cal.get(Calendar.YEAR);
		// int date2 = cal.get(Calendar.MONTH)+1;
		// int date3 = cal.get(Calendar.DAY_OF_MONTH);
		Lunar lunar = new Lunar(cal);
		lunarStr = lunar.animalsYear() + "年(";
		lunarStr += lunar.cyclical() + ")";
		lunarStr += lunar.toString();
		todaydate.setText("农历：" + lunarStr);

		String todaydata = HomePagerActivity.response.getResults().get(0)
				.getWeather_data().get(0).getDate();
		String temperature = HomePagerActivity.response.getResults().get(0)
				.getWeather_data().get(0).getTemperature();
		String subs = null;
		if (todaydata.length() > 14) {
			subs = todaydata.substring(14, todaydata.length() - 1);
			temp.setText(subs);
		} else if (temperature.length() > 5) {
			String[] str = temperature.split("~ ", 2);
			subs = str[1];
			temp.setText(subs);
		} else {
			temp.setText(temperature);
		}

		// 创建SQLite对象并不会创建数据库
		SQLiteCityManager sqlite = new SQLiteCityManager(getActivity(),
				"testdb", null, 1);
		// 读写数据库
		SQLiteDatabase db = sqlite.getWritableDatabase();
		// ContentValues键值对，类似HashMap
		ContentValues cv = new ContentValues();
		// key为字段名，value为所存数据
		cv.put("cityname", HomePagerActivity.response.getResults().get(0)
				.getCurrentCity());
		cv.put("imageurl", HomePagerActivity.response.getResults().get(0)
				.getWeather_data().get(0).getDayPictureUrl());
		cv.put("weather", HomePagerActivity.response.getResults().get(0)
				.getWeather_data().get(0).getWeather());
		cv.put("temp", subs);
		Cursor cursor = db.query("guanoweather", null, null, null, null, null,
				null);
		int i = 0;
		while (cursor.moveToNext()) {
			i++;
			Log.i("TAG", i + "==>>i");
			String cityname = cursor.getString(cursor
					.getColumnIndex("cityname"));
			String weathertext = cursor.getString(cursor
					.getColumnIndex("weather"));
			cityname = cityname.substring(0, 2);
			String citytext = currentcity.getText().toString().substring(0, 2);
			if (citytext.equals(cityname)) {
				if ("点击更新".equals(weathertext)) {
					db.update("guanoweather", cv, "weather = ?",
							new String[] { "点击更新" });
					db.close();
				}
				return;
			}
		}
		// 插入，第二个参数:不能为null的字段
		db.insert("guanoweather", "cityname", cv);
		db.close();
	}

	private View.OnClickListener sendcityonclick = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			pDialog = new ProgressDialog(getActivity());
			pDialog.setCancelable(true);// 点击可以取消Dialog的展现
			pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pDialog.setMessage("正在更新...");
			pDialog.show();
			mactivity.senddata(inputcity);
			mactivity.sendcitytext(inputcity.getText().toString());
		}
	};
}

