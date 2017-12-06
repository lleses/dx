package cn.dc.comm.upload.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.dc.comm.utils.IdUtils;

/**
 * 上传文件
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@RestController
@RequestMapping("upload")
public class UploadController {
	
	// 文件上传后的路径
	@Value("${dc.filePath}")
	private String FILE_PATH;
	@Value("${dc.fileUrlPath}")
	private String FILE_URL_PATH;

	/** 上传图片 **/
	@RequestMapping("img")
	public String img(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return null;
		}
		String fileName = file.getOriginalFilename();// 获取文件名
		String fileSuffix = fileName.substring(fileName.lastIndexOf("."));// 获取文件的后缀名
		fileName = IdUtils.id20() + fileSuffix;
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
