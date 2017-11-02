package cn.dc.order.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.dc.order.dao.OrderRecordRepository;
import cn.dc.order.dao.OrderRelationshipRepository;
import cn.dc.order.dao.OrderRepository;
import cn.dc.order.entity.Order;
import cn.dc.order.entity.OrderRecord;
import cn.dc.order.entity.OrderRelationship;
import cn.dc.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderDao;
	@Autowired
	private OrderRecordRepository orderRecordDao;
	@Autowired
	private OrderRelationshipRepository orderRelationshipDao;

	@Override
	public Order createOrder(String phone, String address, BigDecimal money,String storeId) {
		Order order = new Order(phone, address, money,storeId);
		orderDao.save(order);
		
		return order;
	}
	
	@Override
	public List<Order> getShopOrderList(String storeId,String PayStatusEnum,String OrderStatusEnum, int pageSize,int page){
		return orderDao.findByShopId(storeId);
		
	}

	@Override
	public JSONObject getShopOrderDetail(String orderId) {
		JSONObject orderDetai = new JSONObject();
		/**
		 * 查询订单详情信息
		 */
		Order order = orderDao.findOne(orderId);
		/**
		 * 查询订单状态列表
		 */
		List<OrderRecord>  orderRecord = orderRecordDao.findAll();
		
		/**
		 * 查询订单商品列表
		 */
		List<OrderRelationship> orderRelationship = orderRelationshipDao.findAll();
		
		orderDetai.put("order", order);
		orderDetai.put("orderRecord", orderRecord);
		orderDetai.put("orderRelationship", orderRelationship);
		
		return orderDetai;
	}

	

}
