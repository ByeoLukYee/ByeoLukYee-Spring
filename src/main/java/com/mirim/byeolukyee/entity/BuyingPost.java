package com.mirim.byeolukyee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mirim.byeolukyee.constant.BuyingPostStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("BUYING_POST")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BuyingPost extends Post {

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BuyingPostStatus status = BuyingPostStatus.IN_PROGRESS;

    @JsonIgnore
    @OneToMany(mappedBy = "referenceItem", cascade = CascadeType.ALL)
    private List<SellingComment> referencingItems = new ArrayList<>();

    public void updatePost(String title, String description, Integer price, String location, BuyingPostStatus status) {
        super.updatePost(title, description, price, location);
        this.status = status;
    }

}
