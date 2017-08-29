package cn.dx.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.dx.order.entity.Product;

//controller里面的方法都以json格式输出
@RestController
public class IndexController {

	@RequestMapping("/didi")
	public String didi() {
		List<Product> list = new ArrayList<Product>();
		for (int i = 0; i < 3; i++) {
			Product product = new Product();
			product.setId("1");
			product.setImgSrc("xx");
			product.setName("aa");
			product.setSold(2);
			list.add(product);
		}
		String json = JSON.toJSONString(list);
		return json;
	}

}
