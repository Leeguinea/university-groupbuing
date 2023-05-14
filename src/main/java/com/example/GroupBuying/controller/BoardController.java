package com.example.GroupBuying.controller;

import com.example.GroupBuying.dto.BoardDTO;
import com.example.GroupBuying.entity.Board;
import com.example.GroupBuying.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/gesizak")
    public String writeForm(Model model, HttpSession session) {
        if(session.getAttribute("loginId")==null){
            model.addAttribute("message", "로그인 후 사용이 가능합니다");
            model.addAttribute("searchUrl", "/");
            return "message";
        }
        return "gesi_zak";
    }

    @PostMapping("/gesizak")
    public String write(BoardDTO boardDTO, Model model) {
        boardService.write(boardDTO);
        model.addAttribute("message", "게시물 등록 완료");
        model.addAttribute("searchUrl", "/gesi");
        return "message";
    }

    @GetMapping("/gesi")
    public String postForm(Model model, String searchKey){
        List<Board> boardList = null;
        if(searchKey==null) {
            boardList = boardService.findAll();
        } else {
            boardList = boardService.searchKeyList(searchKey);
        }
        model.addAttribute("boardList", boardList);
        return "gesi";
    }

    @GetMapping("/notice")
    public String noticeForm(){
        return "notice";
    }

    @GetMapping("withdrawal")
    public String drawForm(){
        return "withdrawal";
    }

    @GetMapping("love")
    public String loveForm(){
        return "love";
    }
}
