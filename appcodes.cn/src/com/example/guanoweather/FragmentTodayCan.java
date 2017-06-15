/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package com.example.guanoweather;

import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

import com.example.guanoweather.adapter.GridTodayCAdapter;
import com.example.guanoweather.bean.SportIndexBean;

public class FragmentTodayCan extends Fragment {

	public static final String TAG = "TodayCan";
	public TextView todaycan_dec;
	public SportIndexBean sib, sib1, sib2, sib3, sib4, sib5, sib6, sib7;
	public List<SportIndexBean> listsib;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		HomePagerActivity.TAG_H = TAG;
		View homep_content = inflater.inflate(R.layout.gridview_todaycan, null);

		GridView todayinfo_grid = (GridView) homep_content
				.findViewById(R.id.gridview);
		//描述text
		todaycan_dec = (TextView) homep_content.findViewById(R.id.todaycan_dec);

		listsib = HomePagerActivity.response.getResults().get(0).getIndex();
		Log.i("TAG", listsib.toString()+"==>>listsib.toString()");
		//因为成都的index数据为空
		if (HomePagerActivity.response.getResults().get(0).getIndex()
				.toString() == "[]") {
//			sib = new SportIndexBean();
			Log.i("TAG", todaycan_dec.getText()+"==>>todaycan_dec");
			listsib.add(sib);
			listsib.add(sib1);
			listsib.add(sib2);
			listsib.add(sib3);
			listsib.add(sib4);
			listsib.add(sib5);
			listsib.add(sib6);
			listsib.add(sib7);
			todayinfo_grid.setAdapter(new GridTodayCAdapter(getActivity(), 
					HomePagerActivity.response.getResults().get(0).getIndex()));
		}else {
			sib = new SportIndexBean();
			sib1 = new SportIndexBean();
			Calendar calendar = Calendar.getInstance();
			calendar.get(Calendar.YEAR);
			calendar.get(Calendar.MONTH +1);
			calendar.get(Calendar.DAY_OF_MONTH);
//			calendar.get(Calendar.YEAR)+"年"+
//			calendar.get(Calendar.MONTH +1)+"月"+
//			calendar.get(Calendar.DAY_OF_MONTH)+"日"
			sib.setZs("点击查看");
			sib1.setZs("点击查看");
			sib.setDes("公(阳)历："+calendar.get(Calendar.YEAR)+"年"+
				calendar.get(Calendar.MONTH) +1 +"月"+
				calendar.get(Calendar.DAY_OF_MONTH)+"日"+"\n"+
				"农(阴)历：" + FragmentHomeContent.lunarStr);
			sib1.setDes("雪山。西湖");
			listsib.add(sib);
			listsib.add(sib1);
			todaycan_dec.setText(listsib.get(6).getDes());
			todayinfo_grid.setAdapter(new GridTodayCAdapter(getActivity(),
					listsib));
			listsib = HomePagerActivity.response.getResults().get(0).getIndex();
		}
		todayinfo_grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if(todaycan_dec.getText().equals("")){
					
				}else {
					todaycan_dec.setText(listsib.get(position).getDes());
				}
			}
		});
		return homep_content;
	}
	
}
