package com.mirim.byeolukyee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mirim.byeolukyee.constant.BuyRequestStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@DiscriminatorValue("BUY_REQUEST")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BuyRequest extends Item {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BuyRequestStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "referenceItem")
    private List<SaleOffer> referencingItems;
}
