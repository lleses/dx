package cn.dc.db.module.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.product.entity.Product;
import cn.dc.db.module.product.entity.ProductStatusEnum;

/**
 * 产品
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findById(String id);

	List<Product> findByProductTypeId(String productTypeId);

	List<Product> findByStoreIdAndProductStatusNot(String storeId, ProductStatusEnum productStatus);
}
