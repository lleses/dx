package cn.dc.db.module.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.product.entity.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

//	CommodityType findByNameAndAppId(String name, String appId);
//
//	List<CommodityType> findByAppId(String appId);
}
