package com.zhongying.huanan.product.echarts.util;

import org.apache.commons.httpclient.HttpClient;

public class HttpClientFactory {
	public static void main(String[] args) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet("http://localhost/");
		HttpResponse response = httpclient.execute(httpget);
	}
}
