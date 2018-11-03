package com.patrickstar.tenbyten;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ParsingTest {
	private static Document doc;
	
	@BeforeClass
	public static void setUp() {
		try {
			String url = "http://www.10x10.co.kr/shopping/category_prd.asp?itemid=1622637";
			
			Connection.Response response = Jsoup.connect(url)
					.method(Connection.Method.GET)
					.execute();
			
			doc = response.parse();
			
			System.out.println("# START - Jsoup");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test
	public void getInfo() {
		Elements el = doc.select("dl.saleInfo");
		
		for (Element e : el) {
			Elements dt = e.select("dt");
			if (dt.text().contains("판매가")) {
				String price = dt.next().text();
				System.out.println(price);
			} else if (dt.text().contains("원산지")) {
				String origin = dt.next().text();
				System.out.println(origin);
			}
		}
	}
	
	@Test
	public void getImage() {
		Elements el = doc.select("div.photoSlideV15 > p > img");
		String image = el.first().attr("src");
		System.out.println(image);
	}
	
	@AfterClass
	public static void destroy() {
		System.out.println("# END - Jsoup");
	}
}
