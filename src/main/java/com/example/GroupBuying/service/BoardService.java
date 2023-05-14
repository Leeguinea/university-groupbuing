package com.example.GroupBuying.service;

import com.example.GroupBuying.dto.BoardDTO;
import com.example.GroupBuying.entity.Board;
import com.example.GroupBuying.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
                .datetime(LocalDateTime.now())
                .date(LocalDate.now())
                .build();
        boardRepository.save(board);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public List<Board> findBySearchKeyContaining(String searchKey) {
        return boardRepository.findBySearchKeyContaining(searchKey);
    }
}
