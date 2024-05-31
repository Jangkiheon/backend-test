package kr.co.polycube.backendtest.repository;

import kr.co.polycube.backendtest.entity.Winner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * WinnerRepository 인터페이스 당첨자 정보 엔티티를 관리하기 위한 JPA 레포지토리
 */

public interface WinnerRepository extends JpaRepository<Winner, Long> {
}
