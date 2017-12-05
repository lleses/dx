package cn.dc.busi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.busi.entity.BusinessAccount;

public interface BusinessAccountRepository extends JpaRepository<BusinessAccount, String> {

	BusinessAccount findByUsername(String username);

}
