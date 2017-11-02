package cn.dc.order.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.dc.order.entity.Order;

@Service
public interface OrderService {


	@Transactional
	public Order createOrder(String phone, String address, BigDecimal money,String storeId);
	
	public List<Order> getShopOrderList(String storeId,String PayStatusEnum,String OrderStatusEnum, int pageSize,int page);
	
	public JSONObject getShopOrderDetail(String orderId);

}
