package cn.dc.cart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.cart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	List<Cart> findByUserIdAndStoreId(String userId, String storeId);

}
