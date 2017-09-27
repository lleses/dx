package cn.dc.commodity.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityRepository extends JpaRepository<Commodity, Long> {

	Commodity findByName(String name);

	Commodity findById(int id);

	List<Commodity> findByCommodityTypeId(int id);
}
