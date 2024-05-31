package kr.co.polycube.backendtest.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * LottoDTO 클래스 로또 번호를 전달하기 위한 데이터 전송 객체(DTO).
 */
@Getter
@Setter
public class LottoDTO {
    private Long id;
    private int number1;
    private int number2;
    private int number3;
    private int number4;
    private int number5;
    private int number6;
}
