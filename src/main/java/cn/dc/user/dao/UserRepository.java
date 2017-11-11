package cn.dc.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByOpenid(String openid);

	User findById(int id);

}
