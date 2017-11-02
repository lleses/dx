package cn.dc.order.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cn.dc.order.entity.OrderRelationship;

@Service
public interface OrderRelationshipService {

	
	@Transactional
	public void savrOrderRelationship(OrderRelationship orderRelationship);
	
}
