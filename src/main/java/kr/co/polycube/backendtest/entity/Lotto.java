package kr.co.polycube.backendtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Lotto 클래스 로또 번호를 나타내는 엔티티(Entity)
 */
@Entity
@Getter
@Setter
public class Lotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number1;
    private int number2;
    private int number3;
    private int number4;
    private int number5;
    private int number6;

}
