package cn.dc.user.product.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.comm.dto.impl.ResultInfoImpl;
import cn.dc.db.module.product.dao.ProductRepository;
import cn.dc.db.module.product.entity.Product;
import cn.dc.db.module.product.entity.ProductType;

/**
 * 商品
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@RestController
@RequestMapping("user/product")
public class ProductController {

	@Autowired
	private ProductRepository productDao;

	@RequestMapping("detail")
	public String detail(HttpServletRequest request, String id) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (id == null) {
			rs.errLog("product/detail--值为空");
			return rs.toJson();
		}
		Product product = productDao.findById(id);
		rs = rs.succ(product);
		String json = rs.toJson();
		return json;
	}

}
