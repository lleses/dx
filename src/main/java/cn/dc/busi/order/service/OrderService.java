package cn.dc.busi.order.service;

import cn.dc.comm.dto.ResultInfo;
import cn.dc.db.module.order.entity.Order;

/**
 * 订单业务逻辑
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface OrderService {

	/**
	 *  创建订单
	 *  
	 * @param order
	 * 			订单entity
	 * @return
	 * 			统一返回的结果集合
	 */
	ResultInfo createOrder(Order order);

}
