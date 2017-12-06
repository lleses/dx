package cn.dc.user.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.comm.dto.impl.ResultInfoImpl;
import cn.dc.db.module.product.dao.ProductTypeRepository;
import cn.dc.db.module.product.entity.ProductType;

/**
 * 商品类型
 */
@RestController
@RequestMapping("user/productType")
public class ProductTypeController {
	@Autowired
	private ProductTypeRepository productTypeDao;

	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		List<ProductType> list = productTypeDao.findAll();
		String json = rs.succ(list).toJson();
		return json;
	}

}
