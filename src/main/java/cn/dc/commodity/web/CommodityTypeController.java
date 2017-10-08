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

import cn.dc.cart.domain.ShoppingCart;
import cn.dc.cart.domain.ShoppingCartRepository;
import cn.dc.commodity.domain.Commodity;
import cn.dc.commodity.domain.CommodityRepository;
import cn.dc.commodity.domain.CommodityType;
import cn.dc.commodity.domain.CommodityTypeRepository;

/**
 * 商品类型
 */
@RestController
@RequestMapping("commodity_type")
public class CommodityTypeController {

	@Autowired
	private CommodityTypeRepository commodityTypeDao;
	@Autowired
	private CommodityRepository commodityDao;
	@Autowired
	private ShoppingCartRepository shoppingCartDao;

	@RequestMapping("add")
	public String add(HttpServletRequest request, CommodityType commodityType) {
		CommodityType isNameExist = commodityTypeDao.findByName(commodityType.getName());
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

	@RequestMapping("init_data")
	public String initData(HttpServletRequest request, Integer userId) {
		List<CommodityType> types = commodityTypeDao.findAll();
		List<Commodity> commoditys = getCommoditys(types);
		List<ShoppingCart> shoppingCarts = shoppingCartDao.findByUserId(userId);
		commoditys = setOrderNum(commoditys, shoppingCarts);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("types", types);
		map.put("commoditys", commoditys);
		map.put("shoppingCarts", shoppingCarts);
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

	private List<Commodity> setOrderNum(List<Commodity> commoditys, List<ShoppingCart> shoppingCarts) {
		for (ShoppingCart cart : shoppingCarts) {
			for (Commodity com : commoditys) {
				if (com.getId() == cart.getCommodity().getId()) {
					com.setOrderNum(cart.getNum());
				}
			}
		}
		return commoditys;
	}

	@RequestMapping("selType")
	public String selType(HttpServletRequest request, Integer commodityTypeId, Integer userId) {
		List<Commodity> commoditys = commodityDao.findByCommodityTypeId(commodityTypeId);
		List<ShoppingCart> shoppingCarts = shoppingCartDao.findByUserId(userId);
		commoditys = setOrderNum(commoditys, shoppingCarts);
		String json = JSON.toJSONString(commoditys);
		return json;
	}

	@RequestMapping("getTypeNames")
	public String getTypeNames(HttpServletRequest request) {
		List<CommodityType> arr = commodityTypeDao.findAll();
		String json = JSON.toJSONString(arr);
		return json;
	}

}
