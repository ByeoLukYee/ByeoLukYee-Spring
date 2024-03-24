package com.mirim.byeolukyee.controller;

import com.mirim.byeolukyee.dto.user.AddUserRequestDto;
import com.mirim.byeolukyee.dto.user.SignInUserRequestDto;
import com.mirim.byeolukyee.dto.user.UserResponseDto;
import com.mirim.byeolukyee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.findAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody AddUserRequestDto addUserRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.createUser(addUserRequestDto));
    }

    @PostMapping("/signin")
    public ResponseEntity<UserResponseDto> signInUser(@RequestBody SignInUserRequestDto signInUserRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.signIn(signInUserRequestDto));
    }
}
