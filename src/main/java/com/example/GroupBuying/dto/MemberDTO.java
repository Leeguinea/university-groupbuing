package com.example.GroupBuying.dto;

import lombok.*; // lombok 라이브러리는 클래스에 어노테이션만 붙여주면, 클래스내의 각 필드의 메소드를 생성해준다.

import javax.persistence.GeneratedValue;

@Getter
@Setter
@NoArgsConstructor //기본생성자를 자동 생성
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자를 만들어준다.
@ToString // DTO 객체가 가지고 있는 필드값을 출력할 때 메소드를 생성해준다.
public class MemberDTO { //DTO 클래스는 회원정보에 필요한 내용들을 필드로 정리하고, 접근제한자 private 으로 필드를 감춘다. -> Getter & Setter로만 간접적으로 사용가능하게 한다.
    @GeneratedValue
    private String id;
    private String nickname;
    private String pwd;
    private String name;
    private String phone1;
    private String phone2;
    private String phone3;
    private String year;
    private String month;
    private String day;

}
