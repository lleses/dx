package cn.dc.order.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dc.order.dao.OrderRelationshipRepository;
import cn.dc.order.entity.OrderRelationship;

@Service
public class OrderRelationshipService {

	@Autowired
	private OrderRelationshipRepository orderRelationshipDao;

	@Transactional
	public void save(OrderRelationship orderRelationship) {
		orderRelationshipDao.save(orderRelationship);
	}

}
