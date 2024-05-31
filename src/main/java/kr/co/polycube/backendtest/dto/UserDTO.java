package kr.co.polycube.backendtest.dto;


import lombok.*;

/**
 * UserDTO 클래스 사용자 정보를 전달하기 위한 데이터 전송 객체(DTO)
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;

}
