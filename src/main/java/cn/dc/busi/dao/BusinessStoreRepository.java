package cn.dc.busi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dc.busi.entity.BusinessStore;

public interface BusinessStoreRepository extends JpaRepository<BusinessStore, String> {

	BusinessStore findById(String id);
}
