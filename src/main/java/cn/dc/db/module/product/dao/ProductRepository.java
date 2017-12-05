package cn.dc.db.module.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

//	Commodity findByName(String name);
//
	Product findById(String id);
//
//	List<Commodity> findByCommodityTypeId(int id);
//
//	//TODO 准备删
//	List<Commodity> findByNumGreaterThan(int num);
}
