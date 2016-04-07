package com.zhongying.huanan.product.echarts.util;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ScriptException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlLink;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HTMLUnitFactory {
	public static void main(String[] args) {

		String url = "http://127.0.0.1:8082/echarts/huanan/nos/adsl/AdslServ-bar.html";

		WebClient webClient = new WebClient();

		// webClient.setJavaScriptEnabled(false);
		webClient.setThrowExceptionOnScriptError(false);
		webClient.setThrowExceptionOnFailingStatusCode(false);  

		try {
			
		HtmlPage page = (HtmlPage) webClient.getPage(url);
		
			String jsFunctionStr = "javascript:saveTrackBarImage()";
			// page.getElementById("param").setAttribute("value",
			// reqParamValue);
			String resultObj = "track-bar-image-base64";
	
			 
			HtmlAnchor obj=(HtmlAnchor) page.getElementById("btnSaveImage");
			System.out.println("========================click()=====================================");
			obj.click();
			
			//link.click();
				
				String result = page.getElementById(resultObj).getAttribute("value").toString();

			// result = getActResult(page, jsFunctionStr, resultObj);

			System.err.println(jsFunctionStr + ":" + result);

		}  catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static HtmlPage buildHtmlPage(String url)  {
		WebClient webClient = new WebClient();

		 webClient.setJavaScriptEnabled(false);
		webClient.setThrowExceptionOnScriptError(false);
		webClient.setThrowExceptionOnFailingStatusCode(false);  

		HtmlPage mypage = null;

		System.out.println("url:" + url);

		try {
			mypage = (HtmlPage) webClient.getPage(url);
		} catch (Exception e) {
		} 

		// System.out.println("page body :" + mypage.getBody().asXml());

		return mypage;

	}

	private static String getActResult(HtmlPage page, String jsFunctionStr, String resultObj) {

		System.err.println("exec javascript function:" + jsFunctionStr);

	//	page.executeJavaScript(jsFunctionStr);
		
		
		
		

		String resultStr = page.getElementById(resultObj).getAttribute("value").toString();

		// 得到回调函数的返回值

		return resultStr;

	}
}
