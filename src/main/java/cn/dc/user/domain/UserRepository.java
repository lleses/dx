package cn.dc.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByOpenid(String openid);

	User findById(int id);

	User findBySessionId(String sessionId);

}
