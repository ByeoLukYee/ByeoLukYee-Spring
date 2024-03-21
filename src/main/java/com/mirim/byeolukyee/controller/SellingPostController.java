package com.mirim.byeolukyee.controller;

import com.mirim.byeolukyee.dto.sellingpost.AddSellingPostRequest;
import com.mirim.byeolukyee.dto.sellingpost.SellingPostResponseDto;
import com.mirim.byeolukyee.service.SellingPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/selling-posts")
@RequiredArgsConstructor
public class SellingPostController {

    private final SellingPostService sellingPostService;

    @GetMapping
    public List<SellingPostResponseDto> getAllSellingPosts() {
        return sellingPostService.findAllSellingPosts();
    }

    @GetMapping("/{id}")
    public SellingPostResponseDto getSellingPostById(@PathVariable Long id) {
        return sellingPostService.findSellingPostById(id);
    }

    @PostMapping
    public SellingPostResponseDto createSellingPost(@RequestBody AddSellingPostRequest addSellingPostRequest) {
        return sellingPostService.createSellingPost(addSellingPostRequest);
    }
}
