package cn.dc.client.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.dc.commodity.domain.Commodity;
import cn.dc.commodity.domain.CommodityRepository;

/**
 * 客户
 */
@RestController
@RequestMapping("index")
public class IndexController {
	// 文件上传后的路径
	public final String FILE_PATH = "/Users/didi/Temp/dcFile/";
	public final String FILE_URL_PATH = "/dcFile/";

	@Autowired
	private CommodityRepository commodityDao;

	@RequestMapping("detail")
	public String detail(HttpServletRequest request, int id) {
		Commodity commodity = commodityDao.findById(id);
		String json = JSON.toJSONString(commodity);
		return json;
	}

}
