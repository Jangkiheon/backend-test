package kr.co.polycube.backendtest.service;

import kr.co.polycube.backendtest.dto.UserDTO;
import kr.co.polycube.backendtest.entity.User;
import kr.co.polycube.backendtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * UserService 클래스 사용자 관련 비즈니스 로직을 처리하는 서비스.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 새로운 사용자를 생성하고 저장.
     *
     * @param name 새 사용자의 이름
     * @return 저장된 사용자의 정보를 담은 UserDTO 객체
     */
    public UserDTO createUser(String name) {
        // 사용자 엔티티 생성
        User user = new User(name);
        // 사용자 저장 후 저장된 사용자 정보를 UserDTO 객체로 반환
        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getId(), savedUser.getName());
    }

    /**
     * 주어진 ID에 해당하는 사용자를 조회
     *
     * @param id 조회할 사용자의 ID
     * @return 조회된 사용자의 정보를 담은 Optional<UserDTO> 객체
     */
    public Optional<UserDTO> getUser(Long id) {
        // ID를 이용하여 사용자 조회 후, 조회된 사용자 정보를 UserDTO 객체로 반환
        return userRepository.findById(id).map(user -> new UserDTO(user.getId(), user.getName()));
    }

    /**
     * 주어진 ID에 해당하는 사용자의 이름을 수정
     *
     * @param id   수정할 사용자의 ID
     * @param name 새로운 사용자 이름
     * @return 수정된 사용자 엔티티 객체
     * @throws IllegalArgumentException 주어진 ID에 해당하는 사용자가 없는 경우 발생하는 예외
     */
    public User updateUser(Long id, String name) {
        // ID로 사용자 조회. 사용자가 존재하지 않으면 예외 발생
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
        // 새로운 이름으로 사용자 이름 수정 후 저장
        user.setName(name);
        return userRepository.save(user);
    }
}
