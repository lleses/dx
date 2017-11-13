package cn.dc.commodity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.commodity.entity.Tc;

public interface TcRepository extends JpaRepository<Tc, Long> {

	Tc findById(int id);

}
