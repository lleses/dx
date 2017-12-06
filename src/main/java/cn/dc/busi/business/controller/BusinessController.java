package cn.dc.busi.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dc.comm.reids.RedisUtil;
import cn.dc.comm.utils.IdUtils;
import cn.dc.db.module.busi.dao.BusinessAccountRepository;
import cn.dc.db.module.busi.dao.BusinessRepository;
import cn.dc.db.module.busi.dao.BusinessStoreAccountRelationRepository;
import cn.dc.db.module.busi.dao.BusinessStoreRepository;
import cn.dc.db.module.busi.dao.BusinessUserPushRepository;
import cn.dc.db.module.busi.dao.BusinessUserRepository;
import cn.dc.db.module.busi.entity.BusinessAccount;
import cn.dc.db.module.busi.entity.BusinessUser;

@RestController
@RequestMapping("busi/business")
public class BusinessController {

	@Autowired
	private BusinessRepository businessDao;
	@Autowired
	private BusinessStoreRepository businessStoreDao;
	@Autowired
	private BusinessAccountRepository businessAccountDao;
	@Autowired
	private BusinessStoreAccountRelationRepository businessStoreAccountRelationDao;
	@Autowired
	private BusinessUserRepository businessUserDao;
	@Autowired
	private BusinessUserPushRepository businessUserPushDao;
	@Autowired
	private RedisUtil redisUtil;

	

}
