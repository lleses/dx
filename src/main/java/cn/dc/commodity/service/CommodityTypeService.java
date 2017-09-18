package cn.dc.commodity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dc.commodity.domain.CommodityType;
import cn.dc.commodity.domain.CommodityTypeRepository;

@Service
public class CommodityTypeService {

	@Autowired
	private CommodityTypeRepository commodityTypeRepository;

	public void save(CommodityType commodityType) {
		commodityTypeRepository.save(commodityType);
	}

	public List<CommodityType> findAll() {
		return commodityTypeRepository.findAll();
	}
}
