package kr.co.polycube.backendtest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * LottoResponse 클래스 클라이언트에게 전달할 로또 번호를 포함하는 응답을 나타내는 데이터 전송 객체(DTO).
 */
@Getter
@Setter
public class LottoResponse {
    private List<Integer> numbers;

    public LottoResponse(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
