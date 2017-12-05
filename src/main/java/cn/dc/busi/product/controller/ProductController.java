package cn.dc.busi.product.controller;
//package cn.dc.commodity.controller;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.alibaba.fastjson.JSON;
//
//import cn.dc.commodity.dao.CommodityRepository;
//import cn.dc.commodity.dao.CommodityTypeRepository;
//import cn.dc.commodity.entity.Commodity;
//import cn.dc.commodity.entity.CommodityType;
//import cn.dc.common.utils.IdUtils;
//
///**
// * 商品
// */
//@RestController
//@RequestMapping("product")
//public class ProductController {
//	// 文件上传后的路径
//	@Value("${dc.filePath}")
//	private String FILE_PATH;
//	@Value("${dc.fileUrlPath}")
//	private String FILE_URL_PATH;
//
//	@Autowired
//	private CommodityRepository commodityDao;
//	@Autowired
//	private CommodityTypeRepository commodityTypeDao;
//
//	@RequestMapping("add")
//	public String add(HttpServletRequest request, Commodity commodity) {
//		commodityDao.save(commodity);
//		return "1";
//	}
//
//	@RequestMapping("del")
//	public String del(HttpServletRequest request, int id) {
//		Commodity commodity = commodityDao.findById(id);
//		commodityDao.delete(commodity);
//		return "1";
//	}
//
//	@RequestMapping("to_edit")
//	public String toEdit(HttpServletRequest request, int id) {
//		Commodity commodity = commodityDao.findById(id);
//		List<CommodityType> types = commodityTypeDao.findAll();
//		int typeIndex = 0;
//		int i = 0;
//		for (CommodityType type : types) {
//			if (commodity.getCommodityTypeId() == type.getId()) {
//				typeIndex = i;
//				continue;
//			}
//			i++;
//		}
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("types", types);
//		map.put("commodity", commodity);
//		map.put("typeIndex", typeIndex);
//		String json = JSON.toJSONString(map);
//		return json;
//	}
//
//	@RequestMapping("list")
//	public String list(HttpServletRequest request) {
//		List<Commodity> list = commodityDao.findAll();
//		String json = JSON.toJSONString(list);
//		return json;
//	}
//
//	@RequestMapping("detail")
//	public String detail(HttpServletRequest request, Integer id, Integer orderNum) {
//		if (orderNum == null) {
//			orderNum = 0;
//		}
//		Commodity commodity = commodityDao.findById(id);
//		commodity.setOrderNum(orderNum);
//		String json = JSON.toJSONString(commodity);
//		return json;
//	}
//
//	/** 上传图片 **/
//	@RequestMapping("upload_img")
//	public String uploadImg(@RequestParam("file") MultipartFile file) {
//		if (file.isEmpty()) {
//			return null;
//		}
//		String fileName = file.getOriginalFilename();// 获取文件名
//		String fileSuffix = fileName.substring(fileName.lastIndexOf("."));// 获取文件的后缀名
//		fileName = IdUtils.id20() + fileSuffix;
//		File dest = new File(FILE_PATH + fileName);
//		// 检测是否存在目录
//		if (!dest.getParentFile().exists()) {
//			dest.getParentFile().mkdirs();
//		}
//		try {
//			file.transferTo(dest);
//			return FILE_URL_PATH + fileName;
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//}
