package cn.dc.order.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.dc.order.entity.Product;

@RestController
public class OrderController {

	@RequestMapping("/order")
	public String didi(HttpServletRequest request) {
		String name = request.getParameter("name");
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
