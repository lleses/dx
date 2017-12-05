package cn.dc.commodity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.commodity.entity.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity, Long> {

//	Commodity findByName(String name);
//
	Commodity findById(String id);
//
//	List<Commodity> findByCommodityTypeId(int id);
//
//	//TODO 准备删
//	List<Commodity> findByNumGreaterThan(int num);
}
