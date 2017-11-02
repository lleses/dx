package cn.dc.order.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dc.order.dao.OrderRecordRepository;
import cn.dc.order.dao.OrderRelationshipRepository;
import cn.dc.order.dao.OrderRepository;
import cn.dc.order.entity.Order;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderDao;
	@Autowired
	private OrderRecordRepository orderRecordDao;
	@Autowired
	private OrderRelationshipRepository orderRelationshipDao;
	
	
	

	public Order createOrder(String phone, String address, BigDecimal money) {
		Order order = new Order(phone, address, money);
		orderDao.save(order);
		return order;
	}

}
