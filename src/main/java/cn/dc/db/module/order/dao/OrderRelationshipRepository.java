package cn.dc.db.module.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.order.entity.OrderRelationship;

/**
 * 订购关系
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface OrderRelationshipRepository extends JpaRepository<OrderRelationship, String> {

}
