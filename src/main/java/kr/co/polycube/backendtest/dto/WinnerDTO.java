package kr.co.polycube.backendtest.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * WinnerDTO 클래스 당첨자 정보를 전달하기 위한 데이터 전송 객체(DTO).
 */
@Getter
@Setter
public class WinnerDTO {
    private Long lottoId;
    private String rank;

    public WinnerDTO(Long lottoId, int rank) {
    }
}
