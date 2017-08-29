package cn.dx;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.dx.order.domain.Order;
import cn.dx.order.domain.OrderRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class demo2 {

	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void test() throws Exception {
		//创建10条记录
		for (int i = 0; i < 14; i++) {
			Order order = new Order();
			//order.setId(Long.valueOf(i + 5));
			order.setPrice(i + 6);
			orderRepository.save(order);
		}

		//		Order findOne = orderRepository.findOne(3l);
		//		System.out.println(findOne.toString());
		
		
		

	}

}