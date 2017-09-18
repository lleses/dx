package cn.dc.commodity.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.dc.commodity.domain.Commodity;
import cn.dc.commodity.domain.CommodityRepository;

/**
 * 商品
 */
@RestController
@RequestMapping("commodity")
public class CommodityController {

	@Autowired
	private CommodityRepository commodityDao;

	@RequestMapping("add")
	public String add(HttpServletRequest request, Commodity commodity) {
		Commodity isNameExist = commodityDao.findByName(commodity.getName());
		if (null != isNameExist) {
			return "0";
		}
		commodityDao.save(commodity);
		return "1";
	}

	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		List<Commodity> list = commodityDao.findAll();
		String json = JSON.toJSONString(list);
		return json;
	}

}
