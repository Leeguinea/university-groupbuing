package com.example.GroupBuying.service;

//테스트용 주석
import com.example.GroupBuying.dto.MemberDTO;
import com.example.GroupBuying.entity.MemberEntity;
import com.example.GroupBuying.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public MemberDTO login(MemberDTO memberDTO) {
        /*
            1. 회원이 입력한 아이디를 DB에서 조회함.
            2. 위의 1번이 일치하다면 -> 사용자가 입력한 비밀번호와 DB에서 조회한 비밀번호가 일치하는지 판단.
         */

        Optional<MemberEntity> byId = memberRepository.findById(memberDTO.getId()); //엔티티 객체를 Optional로 감싼 상태
        MemberEntity memberEntity;
        if (byId.isPresent()) {
            //
            // 조회 결과, 해당 Id를 가진 회원정보가 DB에 있다. (비번은 아직 확인 안한 상태)
            memberEntity = byId.get();
            if (memberEntity.getPwd().equals(memberDTO.getPwd())) {
                //비밀번호가 일치하는 경우 -> Entity를 DTO로 변환해서 Controller로 전달해준다.
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                //비밀번호가 불일치(로그인 실패)
                return null;
            }
        } else {
            // 조회 결과가 없다.
            return null;
        }

    }



}
