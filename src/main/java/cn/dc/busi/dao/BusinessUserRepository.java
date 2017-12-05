package cn.dc.busi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.busi.entity.BusinessUser;

public interface BusinessUserRepository extends JpaRepository<BusinessUser, String> {

	BusinessUser findByOpenId(String openId);
}
