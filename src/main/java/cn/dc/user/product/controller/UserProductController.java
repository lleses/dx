package cn.dc.user.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.comm.dto.impl.AbstractResultInfo;
import cn.dc.comm.dto.impl.ResultInfoImpl;
import cn.dc.comm.dto.impl.ResultInfoMapImpl;
import cn.dc.comm.reids.RedisUtil;
import cn.dc.db.module.busi.dao.BusinessStoreRepository;
import cn.dc.db.module.busi.entity.BusinessStore;
import cn.dc.db.module.cart.dao.CartRepository;
import cn.dc.db.module.cart.entity.Cart;
import cn.dc.db.module.product.dao.ProductRepository;
import cn.dc.db.module.product.dao.ProductTypeRepository;
import cn.dc.db.module.product.entity.Product;
import cn.dc.db.module.product.entity.ProductType;
import cn.dc.db.module.user.dao.ConsumerRepository;
import cn.dc.db.module.user.entity.Consumer;

/**
 * 商品
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@RestController
@RequestMapping("user/product")
public class UserProductController {

	@Autowired
	private ProductRepository productDao;
	@Autowired
	private ProductTypeRepository productTypeDao;
	@Autowired
	private CartRepository cartDao;
	@Autowired
	private ConsumerRepository consumerDao;
	@Autowired
	private BusinessStoreRepository businessStoreDao;
	@Autowired
	private RedisUtil redisUtil;

	@RequestMapping("detail")
	public String detail(HttpServletRequest request, String id) {
		ResultInfoImpl<Object> rs = new ResultInfoImpl<>();
		if (id == null) {
			rs.errLog(this.getClass().getName() + "--值为空");
			return rs.toJson();
		}
		Product product = productDao.findById(id);
		Map<String, Object> map = new HashMap<>();
		map.put("product", product);
		String json = rs.succ(map).toJson();
		return json;
	}

	@RequestMapping("list")
	public String list(HttpServletRequest request, String storeId, String sessionId) {
		ResultInfoMapImpl<String, Object> rs = new ResultInfoMapImpl<>();
		String userId = redisUtil.getUserId(sessionId);
		if (userId == null) {
			rs.errLog(this.getClass().getName() + "--userId值为空");
			return rs.toJson();
		}
		Map<String, Object> map = new HashMap<>();
		List<ProductType> productTypes = productTypeDao.findByStoreId(storeId);
		List<Cart> carts = cartDao.findByUserIdAndStoreId(userId, storeId);
		map.put("productTypes", productTypes);
		map.put("carts", carts);
		return rs.succ(map).toJson();
	}

	/** 校验调整首页/店铺列表 **/
	@RequestMapping("check")
	public String check(HttpServletRequest request, String sessionId) {
		ResultInfoMapImpl<String, Object> rs = new ResultInfoMapImpl<>();
		Map<String, Object> map = new HashMap<>();
		String userId = redisUtil.getUserId(sessionId);
		if (userId == null) {
			rs.errLog(this.getClass().getName() + "--userId值为空");
			return rs.toJson();
		}
		Consumer consumer = consumerDao.findById(userId);
		if (consumer == null) {
			rs.errLog(this.getClass().getName() + "--consumer为空");
			return rs.toJson();
		}
		String businessId = consumer.getBusinessId();
		if (businessId == null) {
			rs.errLog(this.getClass().getName() + "--businessId为空");
			return rs.toJson();
		}
		//如果选中门店
		String checkedStoreId = consumer.getCheckedStoreId();
		if (checkedStoreId != null && !"".equals(checkedStoreId)) {
			map.put("url", AbstractResultInfo.TO_INDEX_VIEW);
			map.put("storeId", checkedStoreId);
			return rs.succ(map).toJson();
		}
		List<BusinessStore> stores = businessStoreDao.findByBusinessId(businessId);
		map.put("url", AbstractResultInfo.TO_STORE_LIST_VIEW);
		map.put("stores", stores);
		return rs.succ(map).toJson();
	}

	/** 选中店铺 **/
	@RequestMapping("checkStore")
	public String checkStore(HttpServletRequest request, String sessionId, String storeId) {
		ResultInfoMapImpl<String, Object> rs = new ResultInfoMapImpl<>();
		String userId = redisUtil.getUserId(sessionId);
		if (storeId == null || "".equals(storeId)) {
			rs.errLog(this.getClass().getName() + "--storeId值为空");
			return rs.toJson();
		}
		if (userId == null) {
			rs.errLog(this.getClass().getName() + "--userId值为空");
			return rs.toJson();
		}
		Consumer consumer = consumerDao.findById(userId);
		if (consumer == null) {
			rs.errLog(this.getClass().getName() + "--consumer为空");
			return rs.toJson();
		}
		consumer.setCheckedStoreId(storeId);
		consumerDao.save(consumer);
		return rs.succ().toJson();
	}

}
