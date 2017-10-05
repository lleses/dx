package cn.dc.commodity.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {

	Bill findByUserIdAndIsPay(String userId, boolean isPay);

	Bill findById(int id);

}
