package com.mirim.byeolukyee.controller;

import com.mirim.byeolukyee.dto.sellingpost.AddSellingPostRequest;
import com.mirim.byeolukyee.dto.sellingpost.SellingPostResponseDto;
import com.mirim.byeolukyee.service.SellingPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/selling-posts")
@RequiredArgsConstructor
public class SellingPostController {

    private final SellingPostService sellingPostService;

    @GetMapping
    public ResponseEntity<List<SellingPostResponseDto>> getAllSellingPosts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(sellingPostService.findAllSellingPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellingPostResponseDto> getSellingPostById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(sellingPostService.findSellingPostById(id));
    }

    @PostMapping
    public ResponseEntity<SellingPostResponseDto> createSellingPost(@RequestBody AddSellingPostRequest addSellingPostRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(sellingPostService.createSellingPost(addSellingPostRequest));
    }
}
