package cn.dc.db.module.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.user.entity.User;

/**
 * 消费者信息
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface UserRepository extends JpaRepository<User, Long> {

	//	User findByOpenid(String openid);
	//
	User findById(String id);

}
