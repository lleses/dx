package cn.dc.db.module.busi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.busi.entity.Business;

public interface BusinessRepository extends JpaRepository<Business, String> {

//	Business findByAppId(String appId);

}
