package cn.dc.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.order.entity.OrderRelationship;

public interface OrderRelationshipRepository extends JpaRepository<OrderRelationship, String> {

}
