package kr.co.polycube.backendtest.service;

import kr.co.polycube.backendtest.dto.UserDTO;
import kr.co.polycube.backendtest.entity.User;
import kr.co.polycube.backendtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(String name) {
        User user = new User(name);
        User saveUser = userRepository.save(user);
        return new UserDTO(saveUser.getId(), saveUser.getName());
    }

    public Optional<UserDTO> getUser(Long id) {
        return userRepository.findById(id).map(user -> new UserDTO(user.getId(), user.getName()));
    }

    public User updateUser(Long id, String name) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
        user.setName(name);
        return userRepository.save(user);
    }
}
