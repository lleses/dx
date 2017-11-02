package cn.dc.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dc.order.dao.OrderRelationshipRepository;
import cn.dc.order.entity.OrderRelationship;
import cn.dc.order.service.OrderRelationshipService;

@Service
public class OrderRelationshipServiceImpl implements OrderRelationshipService {

	@Autowired
	private OrderRelationshipRepository orderRelationshipDao;

	@Override
	public void savrOrderRelationship(OrderRelationship orderRelationship) {
		 orderRelationshipDao.save(orderRelationship);
	}



	

}
