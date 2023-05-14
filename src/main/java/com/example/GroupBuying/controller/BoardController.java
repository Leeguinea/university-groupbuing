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
            boardList = boardService.findBySearchKeyContaining(searchKey);
        }
        model.addAttribute("board", boardList);
        return "gesi";
    }
}
