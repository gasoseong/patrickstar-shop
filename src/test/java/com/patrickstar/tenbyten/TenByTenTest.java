package com.patrickstar.tenbyten;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;

public class TenByTenTest {
	@Ignore
	@Test
	public void assertTest() {
		assertEquals(2, 1+1);
	}
	
	@Test
	public void parsingTest() {
		String url = "http://www.10x10.co.kr/shopping/category_prd.asp?itemid=1622637";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Elements el = doc.select("div.pdtBasicV15 > h2 > p.pdtName");
			String productName = el.text();
			System.out.println(productName);
			
			Elements els = doc.select("div#contentWrap > p.fs11.tPad10 > a");
			String category = "";
			for (Element e : els) {
				category += e.text();
				if (e == els.last()) continue;
				category += " > ";
			}
			System.out.println(category);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(new JUnit4TestAdapter(TenByTenTest.class));
	}
}
