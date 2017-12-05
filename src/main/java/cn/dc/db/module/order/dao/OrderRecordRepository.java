package cn.dc.db.module.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.order.entity.OrderRecord;

/**
 * 订单记录
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface OrderRecordRepository extends JpaRepository<OrderRecord, String> {

}
