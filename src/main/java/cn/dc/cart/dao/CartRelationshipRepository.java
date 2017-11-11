package cn.dc.cart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.cart.entity.CartRelationship;

public interface CartRelationshipRepository extends JpaRepository<CartRelationship, Long> {

	List<CartRelationship> findByCartId(int cartId);

	CartRelationship findByCartIdAndCommodityId(int cartId, int commodityId);

}
