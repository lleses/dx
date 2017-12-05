package cn.dc.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String> {

//	Order findById(String id);

}
