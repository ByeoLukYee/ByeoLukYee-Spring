package com.mirim.byeolukyee.controller;

import com.mirim.byeolukyee.dto.user.AddUserRequestDto;
import com.mirim.byeolukyee.dto.user.SignInUserRequestDto;
import com.mirim.byeolukyee.dto.user.UserResponseDto;
import com.mirim.byeolukyee.service.UserService;
import lombok.RequiredArgsConstructor;
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
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody AddUserRequestDto addUserRequestDto) {
        return userService.createUser(addUserRequestDto);
    }

    @PostMapping("/signin")
    public UserResponseDto signInUser(@RequestBody SignInUserRequestDto signInUserRequestDto) {
        return userService.signIn(signInUserRequestDto);
    }
}
