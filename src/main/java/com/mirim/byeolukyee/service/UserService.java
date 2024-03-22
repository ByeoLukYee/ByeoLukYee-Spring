package com.mirim.byeolukyee.service;

import com.mirim.byeolukyee.dto.user.AddUserRequestDto;
import com.mirim.byeolukyee.dto.user.SignInUserRequestDto;
import com.mirim.byeolukyee.dto.user.UserResponseDto;
import com.mirim.byeolukyee.entity.User;
import com.mirim.byeolukyee.exception.DuplicateEmailException;
import com.mirim.byeolukyee.exception.IncorrectPasswordException;
import com.mirim.byeolukyee.exception.UserNotFoundException;
import com.mirim.byeolukyee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public List<UserResponseDto> findAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserResponseDto::from)
                .collect(Collectors.toList());
    }

    public UserResponseDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> UserNotFoundException.EXCEPTION);
        return UserResponseDto.from(user);
    }

    @Transactional
    public UserResponseDto createUser(AddUserRequestDto addUserRequestDto) {
        // 이메일 중복 체크
        checkDuplicateEmail(addUserRequestDto.getEmail());

        // 비밀번호 해싱
        String encodedPassword = encoder.encode(addUserRequestDto.getPassword());

        // 사용자 생성
        User user = User.builder()
                .name(addUserRequestDto.getName())
                .email(addUserRequestDto.getEmail())
                .password(encodedPassword)
                .studentId(addUserRequestDto.getStudentId())
                .build();

        User savedUser = userRepository.save(user);

        // UserResponseDto 생성
        return UserResponseDto.from(savedUser);
    }

    @Transactional
    public UserResponseDto signIn(SignInUserRequestDto signInUserRequestDto) {
        // 이메일로 유저 존재 확인
        User user = userRepository.findByEmail(signInUserRequestDto.getEmail())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        // 비밀번호 확인
        if (BCrypt.checkpw(signInUserRequestDto.getPassword(), user.getPassword()))
            return UserResponseDto.from(user);
        else
            throw IncorrectPasswordException.EXCEPTION;


    }

    private void checkDuplicateEmail(String email) {
        if (userRepository.existsUserByEmail(email)) throw DuplicateEmailException.EXCEPTION;
    }

}
