package cn.dc.db.module.busi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.busi.entity.BusinessStore;

/**
 * 商家门店信息
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface BusinessStoreRepository extends JpaRepository<BusinessStore, String> {

	BusinessStore findById(String id);

	List<BusinessStore> findByBusinessId(String businessId);

}
