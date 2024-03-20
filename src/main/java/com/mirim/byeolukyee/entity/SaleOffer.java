package com.mirim.byeolukyee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mirim.byeolukyee.constant.SaleOfferStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("SALE_OFFER")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaleOffer extends Item {
    @JsonIgnore
    @ManyToOne(targetEntity = BuyRequest.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "reference_item_id")
    private Item referenceItem;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SaleOfferStatus status = SaleOfferStatus.NOT_WON;

    // TODO: 좋아요 수 추가
    // TODO: 조회수 추가
}
