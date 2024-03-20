package com.mirim.byeolukyee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mirim.byeolukyee.constant.BuyingPostStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@DiscriminatorValue("BUYING_POST")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BuyingPost extends Post {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BuyingPostStatus status = BuyingPostStatus.IN_PROGRESS;

    @JsonIgnore
    @OneToMany(mappedBy = "referenceItem")
    private List<SellingComment> referencingItems;
}
