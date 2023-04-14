package com.example.GroupBuying.controller;

import com.example.GroupBuying.dto.MemberDTO;
import com.example.GroupBuying.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //MemberController 를 스프링 객체로 등록해주는 어노테이션
@RequiredArgsConstructor
public class MemberController {
    //생성자 주입
    private final MemberService memberService;


    //회원가입 페이지 출력 요청
    @GetMapping("/GroupBuying/join") //해당 링크를 받으면, 아래 메소드 실행
    public String saveForm() {
        return "join"; //스프링이 templates 폴더에서, join.html 파일을 찾는다. -> 브라우저에 띄워준다.
    }

    //join.html 에서 작성한 회원가입 내용을 받아주는 메소드
    // post 방식으로 데이터를 보냈기 때문에 Postmapping 어노테이션을 사용해서 데이터를 받는다.
    @PostMapping("/GroupBuying/join")
        public String save(@ModelAttribute MemberDTO memberDTO) {  //회원가입에 필요한 정보를 DTO 객체로 받아왔다. (from join.html파일)
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO); //memberService 객체의 save 메소드를 호출하면서 동시에 DTO 객체를 넘겼다.
            return "login";
    }
}
