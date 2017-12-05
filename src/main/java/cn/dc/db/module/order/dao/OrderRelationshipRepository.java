package cn.dc.db.module.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.order.entity.OrderRelationship;

public interface OrderRelationshipRepository extends JpaRepository<OrderRelationship, String> {

}
