package cn.dc;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.dc.order.dao.OrderRepository;
import cn.dc.order.entity.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTests {

	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void test() throws Exception {
		update();
	}

	private void add() {
		Order order = new Order("13416000677", "gdzs", new BigDecimal(1), "1");
		orderRepository.save(order);
	}

	private void update() {
		String id = "20171103204109639995085440747342";
		Order order = orderRepository.findById(id);
		System.out.println("111");
		order.setAddress("hello");
		orderRepository.save(order);
	}

}
