package cn.dc.db.module.cart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.cart.entity.Cart;

/**
 * 购物车
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface CartRepository extends JpaRepository<Cart, Long> {

	Cart findByUserId(String userId);

	List<Cart> findByUserIdAndStoreId(String userId, String storeId);

}
