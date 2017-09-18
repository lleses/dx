package cn.dc.commodity.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

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

	@RequestMapping("init_data")
	public String initData(HttpServletRequest request) {
		List<CommodityType> types = commodityTypeDao.findAll();
		List<Commodity> commoditys = commodityDao.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("types", types);
		map.put("commoditys", commoditys);
		String json = JSON.toJSONString(map);
		return json;
	}

	@RequestMapping("getTypeNames")
	public String getTypeNames(HttpServletRequest request) {
		List<CommodityType> arr = commodityTypeDao.findAll();
		String json = JSON.toJSONString(arr);
		return json;
	}

}
