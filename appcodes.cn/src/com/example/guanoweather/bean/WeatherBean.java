/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package com.example.guanoweather.bean;

import java.util.List;

public class WeatherBean {

	private String currentCity;//当前城市
	private List<WeatherSubBean> weather_data;//天气预报信息
	private String pm25;//PM2.5值
	private List<SportIndexBean> index;//各项指数
	
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public List<WeatherSubBean> getWeather_data() {
		return weather_data;
	}
	public void setWeather_data(List<WeatherSubBean> weather_data) {
		this.weather_data = weather_data;
	}
	public String getPm25() {
		return pm25;
	}
	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}
	public List<SportIndexBean> getIndex() {
		return index;
	}
	public void setIndex(List<SportIndexBean> index) {
		this.index = index;
	}
}
