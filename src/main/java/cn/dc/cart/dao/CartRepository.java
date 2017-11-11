package cn.dc.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.cart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	Cart findByUserId(int userId);

}
