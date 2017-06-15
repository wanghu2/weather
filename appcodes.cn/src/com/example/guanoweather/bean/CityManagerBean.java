/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package com.example.guanoweather.bean;


public class CityManagerBean {

	private String city;//城市
	private String weatherimage;//天气图片
	private String temp;//温度
	private String weather;//天气
	private String dec;//描述
	
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getWeatherimage() {
		return weatherimage;
	}
	public void setWeatherimage(String weatherimage) {
		this.weatherimage = weatherimage;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getDec() {
		return dec;
	}
	public void setDec(String dec) {
		this.dec = dec;
	}
	
}