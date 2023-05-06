package com.example.GroupBuying.controller;

import com.example.GroupBuying.dto.BoardDTO;
import com.example.GroupBuying.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/gesizak")
    public String writeForm(Model model, HttpSession session) {
        return "gesi_zak";
    }

    @PostMapping("/gesizak")
    public String write(BoardDTO boardDTO) {
        boardService.write(boardDTO);
        return "real_fi_gesi";
    }

    @GetMapping("/gesi")
    public String postForm(){
        return "real_fi_gesi";
    }
}
