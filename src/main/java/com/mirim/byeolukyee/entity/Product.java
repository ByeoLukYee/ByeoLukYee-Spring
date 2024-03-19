package com.mirim.byeolukyee.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("PRODUCT")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
