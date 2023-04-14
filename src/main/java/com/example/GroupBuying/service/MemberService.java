package com.example.GroupBuying.service;

import com.example.GroupBuying.dto.MemberDTO;
import com.example.GroupBuying.entity.MemberEntity;
import com.example.GroupBuying.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service //스프링이 관리해주는 객체로 등록
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) { //Controller로 부터 DTO 객체를 받은 save 메소드
        // 조건. entity 객체를 DB로 넘겨주어한다.)
        // (1) dto -> entity 객체로 변환 ---> Entity 클래스에서 작업해준다.
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO); //memberDTO 객체를 넘겨주면서, Entity 의 toMemberEntity 클래스를 호출(객체 변환 실행)
        // (2) entity 객체를 넘겨줄 repository의 save메소드 호출
        memberRepository.save(memberEntity); //repository의 save 메소드 호출(Entity 객체를 넘겨주면서)

    }
}
