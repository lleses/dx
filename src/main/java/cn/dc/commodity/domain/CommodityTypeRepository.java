package cn.dc.commodity.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityTypeRepository extends JpaRepository<CommodityType, Long> {

	CommodityType findByNameAndAppId(String name, String appId);

	List<CommodityType> findByAppId(String appId);
}
