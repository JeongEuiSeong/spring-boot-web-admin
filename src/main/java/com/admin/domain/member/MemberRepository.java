package com.admin.domain.member;

import com.admin.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long>{
    @Query("SELECT p from Member p ORDER BY p.id DESC")
    List<Member> findAllDesc();
}
