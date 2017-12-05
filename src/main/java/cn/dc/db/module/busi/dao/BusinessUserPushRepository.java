package cn.dc.db.module.busi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.db.module.busi.entity.BusinessUserPush;

/**
 * 商家用户消息推送
 * 
 * @author 余狄龙
 * @date 2017年12月6日
 */
public interface BusinessUserPushRepository extends JpaRepository<BusinessUserPush, String> {

}
