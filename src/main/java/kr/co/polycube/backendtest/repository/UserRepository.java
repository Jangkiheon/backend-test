package kr.co.polycube.backendtest.repository;

import kr.co.polycube.backendtest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository 인터페이스 사용자 엔티티를 관리하기 위한 JPA 레포지토리
 */
public interface UserRepository extends JpaRepository<User, Long> { }
