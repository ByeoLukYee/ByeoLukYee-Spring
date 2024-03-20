package com.mirim.byeolukyee.entity;

import com.mirim.byeolukyee.constant.SellingPostStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("SELLING_POST")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SellingPost extends Post {

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SellingPostStatus status = SellingPostStatus.IN_PROGRESS;

    // TODO: 좋아요 수 추가
    // TODO: 조회수 추가
}
