package com.mirim.byeolukyee.controller;

import com.mirim.byeolukyee.dto.buyingpost.AddBuyingPostRequestDto;
import com.mirim.byeolukyee.dto.buyingpost.BuyingPostResponseDto;
import com.mirim.byeolukyee.service.BuyingPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buying-posts")
@RequiredArgsConstructor
public class BuyingPostController {

    private final BuyingPostService buyingPostService;

    @GetMapping
    public ResponseEntity<List<BuyingPostResponseDto>> getAllBuyingPosts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(buyingPostService.findALlBuyingPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuyingPostResponseDto> getBuyingPostById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(buyingPostService.findBuyingPostById(id));
    }

    @PostMapping
    public ResponseEntity<BuyingPostResponseDto> createBuyingRequest(@RequestBody AddBuyingPostRequestDto addBuyingPostRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(buyingPostService.createBuyingPost(addBuyingPostRequestDto));
    }
}
