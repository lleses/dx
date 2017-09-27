package cn.dc.client.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.client.domain.Client;
import cn.dc.client.domain.ClientRepository;

/**
 * 客户
 */
@RestController
@RequestMapping("client")
public class ClientController {
	// 文件上传后的路径
	public final String FILE_PATH = "/Users/didi/Temp/dcFile/";
	public final String FILE_URL_PATH = "/dcFile/";

	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping("add_logo")
	public String addLogo(HttpServletRequest request, Client client) {
		clientRepository.save(client);
		return "1";
	}

}
