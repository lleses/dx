package cn.dc.db.module.busi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.busi.entity.BusinessAccount;

/**
 * 商家账号信息
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface BusinessAccountRepository extends JpaRepository<BusinessAccount, String> {

	BusinessAccount findByUsername(String username);

}
