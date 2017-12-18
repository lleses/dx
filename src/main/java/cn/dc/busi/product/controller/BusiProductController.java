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
import cn.dc.comm.utils.IdUtils;
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

	@RequestMapping("list")
	public String list(HttpServletRequest request, String storeId) {
		ResultInfoMapImpl<String, Object> rs = new ResultInfoMapImpl<>();
		Map<String, Object> map = new HashMap<>();
		List<ProductType> productTypes = productTypeDao.findByStoreId(storeId);
		map.put("productTypes", productTypes);
		return rs.succ(map).toJson();
	}

	@RequestMapping("updateProductStatus")
	public String updateProductStatus(HttpServletRequest request, String productStatus, String storeId, String productId) {
		ResultInfoMapImpl<String, Object> rs = new ResultInfoMapImpl<>();
		ProductStatusEnum ps = ProductStatusEnum.getObj(productStatus);
		if (ps == null) {
			return rs.errLog(this.getClass() + "--枚举为空").toJson();
		}
		Product product = productDao.findById(productId);
		if (product == null) {
			return rs.err("菜品已经被删除").toJson();
		}
		product.setProductStatus(ps);
		productDao.save(product);
		Map<String, Object> map = new HashMap<>();
		List<ProductType> productTypes = productTypeDao.findByStoreId(storeId);
		map.put("productTypes", productTypes);
		return rs.succ(map).toJson();
	}

	/** 批量更新 **/
	@RequestMapping("batchUpdateProductStatus")
	public String batchUpdateProductStatus(HttpServletRequest request, String productStatus, String storeId) {
		ResultInfoMapImpl<String, Object> rs = new ResultInfoMapImpl<>();
		ProductStatusEnum ps = ProductStatusEnum.getObj(productStatus);
		if (ps == null) {
			return rs.errLog(this.getClass() + "--枚举为空").toJson();
		}
		List<Product> products = productDao.findByStoreIdAndProductStatusNot(storeId, ps);
		for (Product product : products) {
			product.setProductStatus(ps);
			productDao.save(product);
		}
		Map<String, Object> map = new HashMap<>();
		List<ProductType> productTypes = productTypeDao.findByStoreId(storeId);
		map.put("productTypes", productTypes);
		return rs.succ(map).toJson();
	}

	@RequestMapping("toSave")
	public String toSave(HttpServletRequest request, String storeId, String id) {
		String[] units = { "碟", "半打", "锅", "2只", "份", "串", "条", "包", "打", "大煲", "中煲", //
				"小煲", "碗", "煲", "时价", "例", "斤", "只", "半只" };
		ResultInfoMapImpl<String, Object> rs = new ResultInfoMapImpl<>();
		Map<String, Object> map = new HashMap<>();
		List<ProductType> productTypes = productTypeDao.findByStoreId(storeId);
		map.put("productTypes", productTypes);
		map.put("units", units);
		if (id != null && !"".equals(id)) {
			Product product = productDao.findById(id);
			map.put("product", product);
			map.put("selTypeId", product.getProductType().getId());
		}
		return rs.succ(map).toJson();
	}

	@RequestMapping("save")
	public String save(HttpServletRequest request, Product product, String productTypeId) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (productTypeId == null) {
			rs = rs.errLog(this.getClass() + "--值为空");
			return rs.toJson();
		}
		if (product.getId() == null || "".equals(product.getId())) {
			product.setId(IdUtils.id32());
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
			rs = rs.errLog(this.getClass() + "--值为空");
			return rs.toJson();
		}
		productDao.delete(product);
		return rs.succ().toJson();
	}

	@RequestMapping("detail")
	public String detail(HttpServletRequest request, String id) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (id == null) {
			rs.errLog(this.getClass() + "--值为空");
			return rs.toJson();
		}
		Product product = productDao.findById(id);
		rs = rs.succ(product);
		String json = rs.toJson();
		return json;
	}

}
