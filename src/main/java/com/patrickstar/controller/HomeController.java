package com.patrickstar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.patrickstar.item.dto.Item;
import com.patrickstar.tenbyten.TenByTenController;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("item")
	public String item(ModelMap modelMap) {
		TenByTenController controller = new TenByTenController();
		Item item = controller.parseItem();
		modelMap.addAttribute(item);
		return "item";
	}
}
