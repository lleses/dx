package cn.dc.commodity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.commodity.entity.CommodityType;

public interface CommodityTypeRepository extends JpaRepository<CommodityType, Long> {

	CommodityType findByNameAndAppId(String name, String appId);

	List<CommodityType> findByAppId(String appId);
}
