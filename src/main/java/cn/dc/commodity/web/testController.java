package cn.dc.commodity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

}
