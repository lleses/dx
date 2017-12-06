package cn.dc.busi.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.comm.dto.impl.ResultInfoImpl;
import cn.dc.comm.utils.ParamUtils;
import cn.dc.db.module.product.dao.ProductRepository;
import cn.dc.db.module.product.dao.ProductTypeRepository;
import cn.dc.db.module.product.entity.Product;
import cn.dc.db.module.product.entity.ProductType;

/**
 * 商品类型
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@RestController
@RequestMapping("busi/productType")
public class ProductTypeController {
	@Autowired
	private ProductTypeRepository productTypeDao;
	@Autowired
	private ProductRepository productDao;

	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		List<ProductType> list = productTypeDao.findAll();
		String json = rs.succ(list).toJson();
		return json;
	}

	@RequestMapping("save")
	public String save(HttpServletRequest request) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		String name = ParamUtils.getStr(request, "name");
		String storeId = ParamUtils.getStr(request, "storeId");
		if (name == null || storeId == null) {
			rs = rs.errLog("productType/save--值为空: name=" + name + ",storeId=" + storeId);
			return rs.toJson();
		}
		ProductType productType = productTypeDao.findByNameAndStoreId(name, storeId);
		if (null != productType) {
			rs = rs.err("菜单类型已经存在");
			return rs.toJson();
		}
		productType = new ProductType(name, storeId);
		productTypeDao.save(productType);
		rs = rs.succ();
		return rs.toJson();
	}

	@RequestMapping("del")
	public String del(HttpServletRequest request, ProductType productType) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (productType.getId() == null) {
			rs = rs.errLog("productType/del--值为空,id=" + productType.getId());
			return rs.toString();
		}

		//TODO测试
		List<Product> products = productDao.findByProductType(productType.getId());
		for (Product product : products) {
			productDao.delete(product);
		}

		productTypeDao.delete(productType);
		List<ProductType> arr = productTypeDao.findAll();
		rs = rs.succ(arr);
		return rs.toJson();
	}

}
