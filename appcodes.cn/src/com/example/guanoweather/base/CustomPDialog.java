/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package com.example.guanoweather.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guanoweather.R;

public class CustomPDialog extends ProgressDialog{
	
	public AnimationDrawable manimation;
	public static String str;
	public static int themeid;
	ImageView mdialogview;
	TextView mdialogtext;
	static CustomPDialog mdialog;

	public static CustomPDialog showPDialog(Context context, String text){
		themeid = R.anim.progressdialog;
		str = text;
		mdialog = new CustomPDialog(context, text, themeid);
		return mdialog;
	}
	
	public CustomPDialog(Context context, String str, int theme) {
		super(context);
		setCanceledOnTouchOutside(true);
//		setOwnerActivity((Activity)context);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
		initData();
	}

	private void initView() {
		setContentView(R.layout.mprogressdialog);
		mdialogview = (ImageView) findViewById(R.id.mdialogview);
		mdialogtext = (TextView) findViewById(R.id.mdialogtext);
	}

	private void initData() {
		mdialogtext.setText(str);
		mdialogview.setBackgroundResource(themeid);
		manimation = (AnimationDrawable) mdialogview.getBackground();
		mdialogview.post(new Runnable() {
			
			@Override
			public void run() {
				manimation.start();
			}
		});
	}
}
