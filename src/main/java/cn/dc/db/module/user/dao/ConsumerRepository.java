package cn.dc.db.module.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.user.entity.Consumer;

/**
 * 消费者信息
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

	Consumer findByOpenid(String openid);

	Consumer findById(String id);

}
