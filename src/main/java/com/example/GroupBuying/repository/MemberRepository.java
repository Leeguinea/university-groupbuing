package com.example.GroupBuying.repository;

import com.example.GroupBuying.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 아이디로 회원 정보 조회(select * from member_table where member_id=?)
    Optional<MemberEntity> findById(String id);

}
