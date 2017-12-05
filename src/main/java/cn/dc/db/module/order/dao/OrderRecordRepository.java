package cn.dc.db.module.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.order.entity.OrderRecord;

public interface OrderRecordRepository extends JpaRepository<OrderRecord, String> {

}
