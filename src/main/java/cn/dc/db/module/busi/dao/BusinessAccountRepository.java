package cn.dc.db.module.busi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.busi.entity.BusinessAccount;

public interface BusinessAccountRepository extends JpaRepository<BusinessAccount, String> {

	BusinessAccount findByUsername(String username);

}
