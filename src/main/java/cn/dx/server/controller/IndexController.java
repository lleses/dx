package cn.dx.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping("/ahello")
	public String index() {
		return "Hello World";
	}
}
