package com.mirim.byeolukyee.repository;

import com.mirim.byeolukyee.entity.BuyingPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyingPostRepository extends JpaRepository<BuyingPost, Long> {
}
