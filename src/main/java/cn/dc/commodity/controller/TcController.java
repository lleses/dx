package cn.dc.commodity.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import cn.dc.commodity.dao.TcRepository;
import cn.dc.commodity.entity.Tc;
import cn.dc.common.utils.IdUtils;

/**
 * 商品
 */
@RestController
@RequestMapping("tc")
public class TcController {
	// 文件上传后的路径
	public final String FILE_PATH = "/Users/didi/Temp/dcFile/";
	public final String FILE_URL_PATH = "/dcFile/";

	@Autowired
	private TcRepository tcDao;

	@RequestMapping("save")
	public String save(HttpServletRequest request, Tc tc) {
		tcDao.save(tc);
		return "1";
	}

	@RequestMapping("del")
	public String del(HttpServletRequest request, int id) {
		Tc tc = tcDao.findById(id);
		tcDao.delete(tc);
		return "1";
	}

	@RequestMapping("to_edit")
	public String toEdit(HttpServletRequest request, int id) {
		Tc tc = tcDao.findById(id);
		String json = JSON.toJSONString(tc);
		return json;
	}

	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		List<Tc> list = tcDao.findAll();
		String json = JSON.toJSONString(list);
		return json;
	}

	@RequestMapping("get")
	public String get(HttpServletRequest request, int id) {
		Tc tc = tcDao.findById(id);
		String json = JSON.toJSONString(tc);
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

}
