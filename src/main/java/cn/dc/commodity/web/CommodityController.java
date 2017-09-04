package cn.dc.commodity.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.dc.commodity.domain.Commodity;
import cn.dc.commodity.domain.CommodityType;
import cn.dc.commodity.service.CommodityService;
import cn.dc.commodity.service.CommodityTypeService;
import cn.dc.utils.ParamUtils;

@RestController
@RequestMapping("/commodity")
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	@Autowired
	private CommodityTypeService commodityTypeService;

	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
		String name = ParamUtils.getStr(request, "name");
		Integer type = ParamUtils.getInt(request, "type");
		String remark = ParamUtils.getStr(request, "remark");

		Commodity commodity = new Commodity();
		commodity.setName(name);
		commodity.setRemark(remark);
		commodity.setType(type);
		commodityService.add(commodity);

		return "succ";
	}

	@RequestMapping("/addType")
	public String addType(HttpServletRequest request) {
		String name = ParamUtils.getStr(request, "name");

		CommodityType type = new CommodityType();
		type.setName(name);
		commodityTypeService.add(type);

		List<CommodityType> findAll = commodityTypeService.findAll();
		String json = JSON.toJSONString(findAll);

		return json;
	}

}
