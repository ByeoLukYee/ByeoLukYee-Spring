package entity;

import constant.ItemStatus;
import constant.ItemType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String location = "미정";

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemStatus status; // ON_SALE, RESERVED, SOLD_OUT

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemType type;  // BUYING, SELLING
}
