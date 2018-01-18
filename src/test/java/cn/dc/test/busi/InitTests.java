package cn.dc.test.busi;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.dc.Application;
import cn.dc.comm.utils.IdUtils;
import cn.dc.db.module.busi.dao.BusinessAccountRepository;
import cn.dc.db.module.busi.dao.BusinessRepository;
import cn.dc.db.module.busi.dao.BusinessStoreAccountRelationRepository;
import cn.dc.db.module.busi.dao.BusinessStoreRepository;
import cn.dc.db.module.busi.dao.BusinessUserPushRepository;
import cn.dc.db.module.busi.dao.BusinessUserRepository;
import cn.dc.db.module.busi.entity.Business;
import cn.dc.db.module.busi.entity.BusinessAccount;
import cn.dc.db.module.busi.entity.BusinessStore;
import cn.dc.db.module.busi.entity.BusinessStoreAccountRelation;
import cn.dc.db.module.busi.entity.BusinessUser;
import cn.dc.db.module.busi.entity.BusinessUserPush;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class InitTests {

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

	@Test
	public void handle() throws Exception {
		init1();
	}

	private void init1() {
		dels();
		adds();
	}

	private void adds() {
		//添加上云商家
		String appId = "wx198ab4de814c9787";
		String appSecret = "1613b6bc9dee35166320bc37e9b6e77f";
		Business business = new Business(appId, appSecret, "上云");
		businessDao.save(business);
		//店铺
		BusinessStore store = new BusinessStore("上云", business.getId());
		businessStoreDao.save(store);
		//账号
		BusinessAccount account = new BusinessAccount("didi", IdUtils.md5("didi"));
		businessAccountDao.save(account);
		//账号-店铺关系
		BusinessStoreAccountRelation saRelation = new BusinessStoreAccountRelation(account.getId(), store.getId());
		businessStoreAccountRelationDao.save(saRelation);
	}

	/** 删除信息,用于初始化 **/
	private void dels() {
		//商家
		List<Business> busis = businessDao.findAll();
		for (Business business : busis) {
			businessDao.delete(business);
		}
		//店铺
		List<BusinessStore> stores = businessStoreDao.findAll();
		for (BusinessStore store : stores) {
			businessStoreDao.delete(store);
		}
		//账号
		List<BusinessAccount> accounts = businessAccountDao.findAll();
		for (BusinessAccount account : accounts) {
			businessAccountDao.delete(account);
		}
		//账号-店铺关系
		List<BusinessStoreAccountRelation> relations = businessStoreAccountRelationDao.findAll();
		for (BusinessStoreAccountRelation relation : relations) {
			businessStoreAccountRelationDao.delete(relation);
		}
		//商家用户
		List<BusinessUser> users = businessUserDao.findAll();
		for (BusinessUser user : users) {
			businessUserDao.delete(user);
		}
		//推送
		List<BusinessUserPush> pushs = businessUserPushDao.findAll();
		for (BusinessUserPush push : pushs) {
			businessUserPushDao.delete(push);
		}
	}

}
