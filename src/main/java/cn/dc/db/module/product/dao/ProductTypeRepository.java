package cn.dc.db.module.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.product.entity.ProductType;

/**
 * 产品类别
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

	//	CommodityType findByNameAndAppId(String name, String appId);
	//
	//	List<CommodityType> findByAppId(String appId);
}
