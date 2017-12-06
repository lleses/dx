package cn.dc.user.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dc.db.module.user.dao.ConsumerRepository;
import cn.dc.db.module.user.entity.Consumer;

/**
 * 消费者业务逻辑
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
@Service
public class ConsumerService {
	@Autowired
	private ConsumerRepository consumerDao;

	/**
	 * 判断是否需要新增消费者信息，并返回消费者ID
	 * 
	 * @param wxSession
	 * 			微信session信息
	 * @param businessId
	 * 			商家ID
	 * @return
	 * 		消费者ID
	 */
	public String checkAddAndGetConsumerId(String openId, String businessId) {
		Consumer consumer = consumerDao.findByOpenid(openId);
		if (consumer == null) {
			consumer = new Consumer();
			consumer.setOpenid(openId);
			consumer.setBusinessId(businessId);
			consumerDao.save(consumer);
		}
		return consumer.getId();
	}

}
