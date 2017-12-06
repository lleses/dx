package cn.dc.test.busi;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.dc.Application;
import cn.dc.comm.utils.HttpUtils;
import cn.dc.db.module.cart.dao.CartRepository;
import cn.dc.db.module.cart.entity.Cart;
import cn.dc.db.module.user.dao.ConsumerRepository;
import cn.dc.db.module.user.entity.Consumer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class OrderTests {

	public static String userId = "20171206070218946233986397421022";
	public static String storeId = "20171206064746743220354400523474";

	@Autowired
	private ConsumerRepository consumerDao;
	@Autowired
	private CartRepository cartDao;

	@Test
	public void handle() throws Exception {
		test();
	}

	private void test() {
		String param = "userId=" + userId + "&storeId=" + storeId + "&payType=WXZF&people=123&address=123";
		String json = HttpUtils.post("http://192.168.31.141:8080/order/create", param, null);
		System.out.println(json);
		//http://localhost:8080/order/create?userId=20171206070218946233986397421022&storeId=20171206064746743220354400523474&&payType=WXZF&people=123&address=123
	}

	private void init() {
		dels();
		adds();
	}

	/** 添加信息 **/
	private void adds() {
		Consumer consumers = new Consumer();
		consumers.setOpenid("2123");
		consumers.setBusinessId("20171206064746399997164295489568");
		consumerDao.save(consumers);

	}

	/** 删除信息,用于初始化 **/
	private void dels() {
		List<Consumer> consumers = consumerDao.findAll();
		for (Consumer consumer : consumers) {
			consumerDao.delete(consumer);
		}
		List<Cart> carts = cartDao.findAll();
		for (Cart cart : carts) {
			cartDao.delete(cart);
		}
	}

}
