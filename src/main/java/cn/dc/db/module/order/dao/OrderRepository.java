package cn.dc.db.module.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String> {

	//	Order findById(String id);

}
