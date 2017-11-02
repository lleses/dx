package cn.dc.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
	
	 List<Order> findByShopId(String shopId);

}
