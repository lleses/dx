package cn.dc.busi.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dc.db.module.busi.dao.BusinessUserRepository;
import cn.dc.db.module.busi.entity.BusinessUser;

@Service
public class BusinessUserService {
	@Autowired
	private BusinessUserRepository businessUserDao;

	/**
	 * 判断是否需要新增商家用户信息，并返回商家用户ID
	 * 
	 * @param wxSession
	 * 			微信session信息
	 * @param businessId
	 * 			商家ID
	 * @return
	 * 		消费者ID
	 */
	public String checkAddAndGetBusinessUserId(String openId, String businessId) {
		BusinessUser businessUser = businessUserDao.findByOpenId(openId);
		if (businessUser == null) {
			businessUser = new BusinessUser(openId, null);
			businessUserDao.save(businessUser);
		}
		return businessUser.getId();
	}

}
