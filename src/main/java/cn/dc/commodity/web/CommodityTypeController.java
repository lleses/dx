package cn.dc.commodity.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.dc.cart.dao.CartRelationshipRepository;
import cn.dc.cart.dao.CartRepository;
import cn.dc.cart.entity.Cart;
import cn.dc.cart.entity.CartRelationship;
import cn.dc.commodity.domain.Commodity;
import cn.dc.commodity.domain.CommodityRepository;
import cn.dc.commodity.domain.CommodityType;
import cn.dc.commodity.domain.CommodityTypeRepository;
import cn.dc.common.redis.RedisUtil;

/**
 * 商品类型
 */
@RestController
@RequestMapping("commodity_type")
public class CommodityTypeController {
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private CommodityTypeRepository commodityTypeDao;
	@Autowired
	private CommodityRepository commodityDao;
	@Autowired
	private CartRepository cartDao;
	@Autowired
	private CartRelationshipRepository cartRelationshipDao;

	@RequestMapping("init_data")
	public String initData(HttpServletRequest request, String sessionId, String appId) {
		String sessionVal = (String) redisUtil.get(sessionId);
		//TODO 不严谨
		Integer userId = Integer.valueOf(sessionVal.split("#")[2]);
		List<CommodityType> types = commodityTypeDao.findByAppId(appId);
		List<Commodity> commoditys = getCommoditys(types);
		Cart cart = cartDao.findByUserId(userId);
		if (cart != null) {
			List<CartRelationship> cartRelationships = cartRelationshipDao.findByCartId(cart.getId());
			commoditys = setOrderNum(commoditys, cartRelationships);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("types", types);
		map.put("commoditys", commoditys);
		String json = JSON.toJSONString(map);
		return json;
	}

	private List<Commodity> getCommoditys(List<CommodityType> types) {
		List<Commodity> commoditys = new ArrayList<Commodity>();
		if (types.size() > 0) {
			Integer commodityTypeId = types.get(0).getId();
			commoditys = commodityDao.findByCommodityTypeId(commodityTypeId);
		}
		return commoditys;
	}

	private List<Commodity> setOrderNum(List<Commodity> commoditys, List<CartRelationship> cartRelationships) {
		for (CartRelationship cart : cartRelationships) {
			for (Commodity com : commoditys) {
				if (com.getId() == cart.getCommodity().getId()) {
					com.setOrderNum(cart.getNum());
				}
			}
		}
		return commoditys;
	}

	@RequestMapping("selType")
	public String selType(HttpServletRequest request, Integer commodityTypeId, String sessionId) {
		String sessionVal = (String) redisUtil.get(sessionId);
		//TODO 不严谨
		Integer userId = Integer.valueOf(sessionVal.split("#")[2]);
		List<Commodity> commoditys = commodityDao.findByCommodityTypeId(commodityTypeId);
		Cart cart = cartDao.findByUserId(userId);
		if (cart != null) {
			List<CartRelationship> cartRelationships = cartRelationshipDao.findByCartId(cart.getId());
			commoditys = setOrderNum(commoditys, cartRelationships);
		}
		String json = JSON.toJSONString(commoditys);
		return json;
	}

	@RequestMapping("getTypeNames")
	public String getTypeNames(HttpServletRequest request, String appId) {
		List<CommodityType> arr = commodityTypeDao.findByAppId(appId);
		String json = JSON.toJSONString(arr);
		return json;
	}

	@RequestMapping("add")
	public String add(HttpServletRequest request, CommodityType commodityType) {
		CommodityType isNameExist = commodityTypeDao.findByNameAndAppId(commodityType.getName(), commodityType.getAppId());
		if (null != isNameExist) {
			return "0";
		}
		commodityTypeDao.save(commodityType);

		List<CommodityType> arr = commodityTypeDao.findAll();
		String json = JSON.toJSONString(arr);
		return json;
	}

	@RequestMapping("del")
	public String del(HttpServletRequest request, CommodityType commodityType) {
		commodityTypeDao.delete(commodityType);
		List<CommodityType> arr = commodityTypeDao.findAll();
		String json = JSON.toJSONString(arr);
		return json;
	}

}
