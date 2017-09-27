package cn.dc.commodity.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TcRepository extends JpaRepository<Tc, Long> {

	Tc findById(int id);

}
