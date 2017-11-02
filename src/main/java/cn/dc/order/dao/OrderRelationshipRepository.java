package cn.dc.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.order.entity.Order;

public interface OrderRelationshipRepository extends JpaRepository<Order, Long> {

}
