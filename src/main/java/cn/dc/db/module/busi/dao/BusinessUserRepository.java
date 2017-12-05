package cn.dc.db.module.busi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.busi.entity.BusinessUser;

/**
 * 商家用户信息
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface BusinessUserRepository extends JpaRepository<BusinessUser, String> {

	BusinessUser findByOpenId(String openId);
}
