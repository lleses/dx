package cn.dc.busi.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.comm.dto.impl.ResultInfoImpl;
import cn.dc.comm.dto.impl.ResultInfoMapImpl;
import cn.dc.db.module.product.dao.ProductRepository;
import cn.dc.db.module.product.dao.ProductTypeRepository;
import cn.dc.db.module.product.entity.Product;
import cn.dc.db.module.product.entity.ProductStatusEnum;
import cn.dc.db.module.product.entity.ProductType;

/**
 * 商品
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@RestController
@RequestMapping("busi/product")
public class BusiProductController {

	@Autowired
	private ProductRepository productDao;
	@Autowired
	private ProductTypeRepository productTypeDao;

	@RequestMapping("toSave")
	public String toSave(HttpServletRequest request, String storeId, String id) {
		String[] units = { "碟", "半打", "锅", "2只", "份", "串", "条", "包", "打", "大煲", "中煲", //
				"小煲", "碗", "煲", "时价", "例", "斤", "只", "半只" };
		ResultInfoMapImpl<String, Object> rs = new ResultInfoMapImpl<>();
		Map<String, Object> map = new HashMap<>();
		List<ProductType> productTypes = productTypeDao.findByStoreId(storeId);
		map.put("productTypes", productTypes);
		map.put("units", units);
		if (id != null || !"".equals(id)) {
			Product product = productDao.findById(id);
			map.put("product", product);
		}
		return rs.succ(map).toJson();
	}

	@RequestMapping("save")
	public String save(HttpServletRequest request, Product product, String productTypeId) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (productTypeId == null) {
			rs = rs.errLog("product/save--值为空");
			return rs.toJson();
		}
		product.setProductStatus(ProductStatusEnum.SJ);
		product.setProductType(new ProductType(productTypeId));
		productDao.save(product);
		return rs.succ().toJson();
	}

	@RequestMapping("del")
	public String del(HttpServletRequest request, String id) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		Product product = productDao.findById(id);
		if (product == null) {
			rs = rs.errLog("product/del--值为空");
			return rs.toJson();
		}
		productDao.delete(product);
		return rs.succ().toJson();
	}

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
