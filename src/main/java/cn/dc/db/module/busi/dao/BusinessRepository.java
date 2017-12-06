package cn.dc.db.module.busi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.busi.entity.Business;

/**
 * 商家信息
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface BusinessRepository extends JpaRepository<Business, String> {

	Business findByAppId(String appId);

}
