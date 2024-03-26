package com.mirim.byeolukyee.service;

import com.mirim.byeolukyee.dto.sellingpost.AddSellingPostRequest;
import com.mirim.byeolukyee.dto.sellingpost.SellingPostResponseDto;
import com.mirim.byeolukyee.dto.sellingpost.UpdateSellingPostRequest;
import com.mirim.byeolukyee.entity.SellingPost;
import com.mirim.byeolukyee.entity.User;
import com.mirim.byeolukyee.exception.PostNotFoundException;
import com.mirim.byeolukyee.exception.UserNotFoundException;
import com.mirim.byeolukyee.repository.SellingPostRepository;
import com.mirim.byeolukyee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SellingPostService {

    private final SellingPostRepository sellingPostRepository;
    private final UserRepository userRepository;


    public List<SellingPostResponseDto> findAllSellingPosts() {
        List<SellingPost> sellingPosts = sellingPostRepository.findAll();
        return sellingPosts.stream()
                .map(SellingPostResponseDto::from)
                .collect(Collectors.toList());
    }

    public SellingPostResponseDto findSellingPostById(Long id) {
        SellingPost sellingPost = sellingPostRepository.findById(id).orElseThrow(() -> PostNotFoundException.EXCEPTION);
        return SellingPostResponseDto.from(sellingPost);
    }

    @Transactional
    public SellingPostResponseDto createSellingPost(AddSellingPostRequest addSellingPostRequest) {

        User user = userRepository.findById(addSellingPostRequest.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        SellingPost sellingPost = SellingPost.builder()
                .isDeleted(false)
                .user(user)
                .title(addSellingPostRequest.getTitle())
                .description(addSellingPostRequest.getDescription())
                .price(addSellingPostRequest.getPrice())
                .location(addSellingPostRequest.getLocation())
                .build();

        SellingPost savedSellingPost = sellingPostRepository.save(sellingPost);

        return SellingPostResponseDto.from(savedSellingPost);
    }

    @Transactional
    public SellingPostResponseDto updateSellingPost(Long id, UpdateSellingPostRequest updateSellingPostRequest) {
        SellingPost sellingPost = sellingPostRepository.findById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        sellingPost.updatePost(
                updateSellingPostRequest.getTitle(),
                updateSellingPostRequest.getDescription(),
                updateSellingPostRequest.getPrice(),
                updateSellingPostRequest.getLocation()
        );

        SellingPost updatedSellingpost = sellingPostRepository.save(sellingPost);

        return SellingPostResponseDto.from(updatedSellingpost);
    }


}
