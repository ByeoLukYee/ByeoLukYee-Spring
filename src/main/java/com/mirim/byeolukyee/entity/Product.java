package com.mirim.byeolukyee.entity;

import com.mirim.byeolukyee.constant.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("PRODUCT")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends Item {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductStatus status;

    // TODO: 좋아요 수 추가
    // TODO: 조회수 추가
}
