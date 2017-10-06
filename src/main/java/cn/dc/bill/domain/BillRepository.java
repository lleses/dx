package cn.dc.bill.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {

	Bill findById(int id);

}
