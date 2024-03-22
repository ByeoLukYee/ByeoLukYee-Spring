package com.mirim.byeolukyee.controller;

import com.mirim.byeolukyee.dto.buyingpost.AddBuyingPostRequestDto;
import com.mirim.byeolukyee.dto.buyingpost.BuyingPostResponseDto;
import com.mirim.byeolukyee.service.BuyingPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buying-posts")
@RequiredArgsConstructor
public class BuyingPostController {

    private final BuyingPostService buyingPostService;

    @GetMapping
    public List<BuyingPostResponseDto> getAllBuyingPosts() {
        return buyingPostService.findALlBuyingPosts();
    }

    @GetMapping("/{id}")
    public BuyingPostResponseDto getBuyingPostById(@PathVariable Long id) {
        return buyingPostService.findBuyingPostById(id);
    }

    @PostMapping
    public BuyingPostResponseDto createBuyingRequest(@RequestBody AddBuyingPostRequestDto addBuyingPostRequestDto) {
        return buyingPostService.createBuyingPost(addBuyingPostRequestDto);
    }
}
