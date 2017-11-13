package cn.dc.commodity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dc.commodity.dao.CommodityRepository;
import cn.dc.commodity.entity.Commodity;

@Service
public class CommodityService {

	@Autowired
	private CommodityRepository commodityRepository;

	public void add(Commodity commodity) {
		commodityRepository.save(commodity);
	}

}
