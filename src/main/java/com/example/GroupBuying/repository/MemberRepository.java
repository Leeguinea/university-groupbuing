package com.example.GroupBuying.repository;

import com.example.GroupBuying.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
