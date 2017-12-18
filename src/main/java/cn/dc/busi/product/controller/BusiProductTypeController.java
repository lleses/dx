package cn.dc.busi.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.comm.dto.impl.ResultInfoImpl;
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
public class BusiProductTypeController {
	@Autowired
	private ProductTypeRepository productTypeDao;
	@Autowired
	private ProductRepository productDao;

	@RequestMapping("save")
	public String save(HttpServletRequest request, String name, String storeId) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		ProductType productType = productTypeDao.findByNameAndStoreId(name, storeId);
		if (null != productType) {
			rs = rs.err("菜单类型已经存在");
			return rs.toJson();
		}
		productType = new ProductType(name, storeId);
		productTypeDao.save(productType);
		List<ProductType> productTypes = productTypeDao.findByStoreId(storeId);
		return rs.succ(productTypes).toJson();
	}

	@RequestMapping("del")
	public String del(HttpServletRequest request, ProductType productType) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (productType.getId() == null) {
			rs = rs.errLog("productType/del--值为空,id=" + productType.getId());
			return rs.toString();
		}

		List<Product> products = productDao.findByProductTypeId(productType.getId());
		for (Product product : products) {
			productDao.delete(product);
		}

		productTypeDao.delete(productType);

		List<ProductType> productTypes = productTypeDao.findByStoreId(productType.getStoreId());
		return rs.succ(productTypes).toJson();
	}

}
