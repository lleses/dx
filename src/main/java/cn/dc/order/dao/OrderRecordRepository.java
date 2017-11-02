package cn.dc.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.order.entity.OrderRecord;

public interface OrderRecordRepository extends JpaRepository<OrderRecord, Long> {

}
