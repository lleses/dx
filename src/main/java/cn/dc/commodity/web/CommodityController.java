package cn.dc.commodity.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import cn.dc.commodity.domain.Commodity;
import cn.dc.commodity.domain.CommodityRepository;
import cn.dc.commodity.domain.CommodityType;
import cn.dc.commodity.domain.CommodityTypeRepository;
import cn.dc.utils.IdUtils;

/**
 * 商品
 */
@RestController
@RequestMapping("commodity")
public class CommodityController {
	// 文件上传后的路径
	public final String FILE_PATH = "/Users/didi/Temp/dcFile/";
	public final String FILE_URL_PATH = "/dcFile/";

	@Autowired
	private CommodityRepository commodityDao;
	@Autowired
	private CommodityTypeRepository commodityTypeDao;

	@RequestMapping("add")
	public String add(HttpServletRequest request, Commodity commodity) {
		commodityDao.save(commodity);
		return "1";
	}
	

	@RequestMapping("del")
	public String del(HttpServletRequest request, int id) {
		Commodity commodity = commodityDao.findById(id);
		commodityDao.delete(commodity);
		return "1";
	}

	@RequestMapping("to_edit")
	public String toEdit(HttpServletRequest request, int id) {
		Commodity commodity = commodityDao.findById(id);
		List<CommodityType> types = commodityTypeDao.findAll();
		int typeIndex = 0;
		int i = 0;
		for (CommodityType type : types) {
			if (commodity.getCommodityTypeId() == type.getId()) {
				typeIndex = i;
				continue;
			}
			i++;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("types", types);
		map.put("commodity", commodity);
		map.put("typeIndex", typeIndex);
		String json = JSON.toJSONString(map);
		return json;
	}

	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		List<Commodity> list = commodityDao.findAll();
		String json = JSON.toJSONString(list);
		return json;
	}

	/** 上传图片 **/
	@RequestMapping("upload_img")
	public String uploadImg(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return null;
		}
		String fileName = file.getOriginalFilename();// 获取文件名
		String fileSuffix = fileName.substring(fileName.lastIndexOf("."));// 获取文件的后缀名
		fileName = IdUtils.id32() + fileSuffix;
		File dest = new File(FILE_PATH + fileName);
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			return FILE_URL_PATH + fileName;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	//	private String succ(String msg, String filePath) {
	//		return rsJson(msg, "1", filePath);
	//	}
	//
	//	private String err(String msg) {
	//		return rsJson(msg, "-1", null);
	//	}
	//
	//	private String rsJson(String msg, String status, String filePath) {
	//		Map<String, Object> map = new HashMap<String, Object>();
	//		//map.put("msg", msg);
	//		map.put("status", status);
	//		map.put("rs", filePath);
	//		String json = JSON.toJSONString(map);
	//		return json;
	//	}

}
