package cn.dc.commodity.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityRepository extends JpaRepository<Commodity, Long> {
	Commodity findByName(String name);
}
