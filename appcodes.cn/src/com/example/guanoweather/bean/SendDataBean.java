/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package com.example.guanoweather.bean;


public class SendDataBean {

	public static String city = "";
	public static String json = "json";
	public static String ak = "iGs8rFvzh1e8c7C9DjXT5toK";
	
	public static void setCity(String city) {
		SendDataBean.city = city;
	}
	public static void setJson(String json) {
		SendDataBean.json = json;
	}
	public static void setAk(String ak) {
		SendDataBean.ak = ak;
	}
	public static String getCity() {
		return city;
	}
	public static String getJson() {
		return json;
	}
	public static String getAk() {
		return ak;
	}
	public static String getData() {
		return "http://api.map.baidu.com/telematics/v3/weather?location=" +
				city + "&output="+ json +"&ak="+ ak;
	}
//http://api.map.baidu.com/telematics/v3/weather?location=北京&output=json&ak=iGs8rFvzh1e8c7C9DjXT5toK

	
}
