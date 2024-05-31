package kr.co.polycube.backendtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Winner 클래스 당첨자 정보를 나타내는 엔티티(Entity)
 */
@Entity
@Getter
@Setter
public class Winner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long lottoId;
    private int rank;

}
