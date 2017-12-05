package cn.dc.db.module.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.order.entity.Order;

/**
 * 订单
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface OrderRepository extends JpaRepository<Order, String> {

	//	Order findById(String id);

}
