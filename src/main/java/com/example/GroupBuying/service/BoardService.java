package com.example.GroupBuying.service;

import com.example.GroupBuying.dto.BoardDTO;
import com.example.GroupBuying.entity.Board;
import com.example.GroupBuying.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void write(BoardDTO boardDTO) {
        Board board = Board.builder()
                .id(boardDTO.getId())
                .title(boardDTO.getTitle())
                .item(boardDTO.getItem())
                .category(boardDTO.getCategory())
                .content(boardDTO.getContent())
                .recruitment(boardDTO.getRecruitment())
                .build();
        boardRepository.save(board);
    }
}
