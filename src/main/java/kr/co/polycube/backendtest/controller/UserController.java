package kr.co.polycube.backendtest.controller;

import kr.co.polycube.backendtest.dto.UserDTO;
import kr.co.polycube.backendtest.entity.User;
import kr.co.polycube.backendtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * UserController 클래스 "/users" 엔드포인트에 대한 요청을 처리.
 * 사용자 생성, 조회 및 수정 요청을 처리, 서비스를 호출 및 작업.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * /users" 엔드포인트로 요청이 오면 호출.
     * 요청으로부터 받은 사용자 데이터를 생성하고, 생성된 user 정보를 반환.
     *
     * @param userDTO 요청으로부터 받은 사용자 정보 DTO
     * @return 생성된 사용자 정보 DTO
     */
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO.getName());
    }

    /**
     * GET 메소드로 "/users/{id}" 엔드포인트로 요청이 오면 호출.
     * 요청으로부터 받은 사용자 ID를 사용하여 해당 ID에 해당하는 사용자 정보를 조회 후 반환.
     *
     * @param id 요청으로부터 받은 사용자 ID
     * @return 사용자 정보 DTO를 Optional로 감싼 결과
     */
    @GetMapping("/{id}")
    public Optional<UserDTO> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    /**
     * PUT 메소드로 "/users/{id}" 엔드포인트로 요청이 오면 호출되는 메서드입니다.
     * 요청으로부터 받은 사용자 ID와 새로운 사용자 이름을 사용하여 해당 사용자 정보를 업데이트하고, 업데이트된 사용자 정보를 반환.
     *
     * @param id      요청으로부터 받은 사용자 ID
     * @param userDTO 요청으로부터 받은 새로운 사용자 정보 DTO
     * @return 업데이트된 사용자 정보
     */
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO.getName());
    }

}
