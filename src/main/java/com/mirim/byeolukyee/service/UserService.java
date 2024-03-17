package com.mirim.byeolukyee.service;

import com.mirim.byeolukyee.entity.User;
import com.mirim.byeolukyee.exception.DuplicateEmailException;
import com.mirim.byeolukyee.exception.UserNotFoundException;
import com.mirim.byeolukyee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    @Transactional(readOnly = false)
    public User createUser(User user) {
        // 이메일 중복 체크
        checkDuplicateEmail(user.getEmail());

        // 비밀번호 해싱
        String password = user.getPassword();
        String encodedPassword = encoder.encode(password);
        user.builder().password(encodedPassword);

        return userRepository.save(user);
    }

    private void checkDuplicateEmail(String email) {
        if (userRepository.existsUserByEmail(email)) throw DuplicateEmailException.EXCEPTION;
    }

}
