package kr.co.polycube.backendtest.repository;

import kr.co.polycube.backendtest.entity.Lotto;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * LottoRepository 인터페이스 로또 번호 엔티티를 관리하기 위한 JPA 레포지토리
 */
public interface LottoRepository extends JpaRepository<Lotto, Long> {
}
