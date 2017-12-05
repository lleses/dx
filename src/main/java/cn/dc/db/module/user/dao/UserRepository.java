package cn.dc.db.module.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	//	User findByOpenid(String openid);
	//
	User findById(String id);

}
