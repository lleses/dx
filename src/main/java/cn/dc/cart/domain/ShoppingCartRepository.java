package cn.dc.cart.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

	List<ShoppingCart> findByUserId(int userId);

	ShoppingCart findByUserIdAndCommodityId(int userId, int commodityId);

}
