package com.study.jsspider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderUtilsNew {
	private Document doc = null;

	/**
	 *    获取条目列表，<条目名称,更新时间>
	 *    必须先调用getDownloadURL()方法，否则会报错！
	 * @param URL
	 * @return
	 * @throws IOException
	 */
	private Map<String, String> getMessage () {
		Map<String, String> map = new HashMap<String, String>();
		Elements elements = doc.select(".fl");
		for (Element element : elements) {
			if (element.childNodeSize()==5) {
//				System.out.println(element.child(0).text());
//				System.out.println(element.child(1).text());
//				System.out.println("======================================");
				map.put(element.child(0).text(), element.child(1).text());
				
			}
		}
		return map;
	} 
	
	/**
	 * 解析网页，生成下载地址，内部调用getMessage ()
	 * @param URL
	 * @throws IOException
	 */
	public void getDownloadURL (String URL,StringBuilder builder) throws IOException {
		this.doc = Jsoup.connect(URL).get();
		String realUrl = null;
//		Map<String, String> map = this.getMessage();
		Elements elements = doc.select("li.clearfix");
		String str = null;
		for (Element element : elements) {
			realUrl = "https://www.jieshun.cn" + element.child(0).attr("href");
			str = element.child(0).attr("download");

			element.child(0).child(1).text();
			System.out.println(str);
			System.out.println(element.child(0).child(1).text());
			System.out.println(realUrl);
			System.out.println("=************************************=");
			builder.append(str);
			builder.append("\r\n");
//			builder.append(map.get(str));
			builder.append(element.child(0).child(1).text());
			builder.append("\r\n");
			builder.append(realUrl);
			builder.append("\r\n\r\n\r\n");
		}
		str = null;
	}

}
