//package cn.dc.order.service.impl;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import cn.dc.order.dao.OrderRelationshipRepository;
//import cn.dc.order.entity.OrderRelationship;
//import cn.dc.order.service.OrderRelationshipService;
//
//@Service
//public class OrderRelationshipServiceImpl implements OrderRelationshipService {
//
//	@Autowired
//	private OrderRelationshipRepository orderRelationshipDao;
//
//	@Override
//	@Transactional
//	public void savrOrderRelationship(OrderRelationship orderRelationship) {
//		orderRelationshipDao.save(orderRelationship);
//	}
//
//}
