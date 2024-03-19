package com.mirim.byeolukyee.entity;

import com.mirim.byeolukyee.constant.ItemStatus;
import com.mirim.byeolukyee.constant.ItemType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer price;

    @Builder.Default
    @Column(nullable = false)
    private String location = "거래 희망 장소가 없습니다.";

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemStatus status; // PROCEEDING, RESERVED, COMPLETE

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemType type;  // PRODUCT, BUY_REQUEST, SALE_OFFER
}
