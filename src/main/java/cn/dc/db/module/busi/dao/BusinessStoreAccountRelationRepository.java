package cn.dc.db.module.busi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.busi.entity.BusinessStoreAccountRelation;

/**
 * 商家 店面-账号 关系
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface BusinessStoreAccountRelationRepository extends JpaRepository<BusinessStoreAccountRelation, String> {

}
