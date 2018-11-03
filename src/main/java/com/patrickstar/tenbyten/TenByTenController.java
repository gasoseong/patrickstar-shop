package com.patrickstar.tenbyten;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patrickstar.item.dto.Item;

public class TenByTenController {
	Logger logger = LoggerFactory.getLogger(TenByTenController.class);
	
	public Item parseItem() {
		Item item = new Item();
		
		String url = "http://www.10x10.co.kr/shopping/category_prd.asp?itemid=1622637";
		item.setUrl(url);
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			// 상품명
			Elements el = doc.select("div.pdtBasicV15 > h2 > p.pdtName");
			String productName = el.text();
			item.setName(productName);
			
			// 카테고리명
			el = doc.select("div#contentWrap > p.fs11.tPad10 > a");
			String category = "";
			for (Element e : el) {
				category += e.text();
				if (e == el.last()) continue;
				category += " > ";
			}
			item.setCategory(category);
			
			// 상품 이미지
			el = doc.select("div.photoSlideV15 > p > img");
			String image = el.first().attr("src");
			item.setImage(image);
			
			// 상품 상세정보
			el = doc.select("dl.saleInfo");
			for (Element e : el) {
				Elements dt = e.select("dt");
				if (dt.text().contains("판매가")) {
					String price = dt.next().text();
					item.setPrice(price);
				} else if (dt.text().contains("원산지")) {
					String origin = dt.next().text();
					item.setOrigin(origin);
				}
			}
			
			return item;
		} catch (IOException e) {
			logger.debug(this.getClass().getSimpleName(), e);
		}
		
		return null;
	}
}
