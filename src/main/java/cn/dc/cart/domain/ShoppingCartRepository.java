package cn.dc.cart.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

	ShoppingCart findByUserId(int userId);

	ShoppingCart findByUserIdAndCommodityId(int userId, int commodityId);

}
