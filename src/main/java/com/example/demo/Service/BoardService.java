package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

@Service
public interface BoardService {
    // 게시물 등록
    int register(BoardDTO dto);

    // 게시물 목록조회
    List<BoardDTO> getList();

    // 게시물 상세조회
    BoardDTO read(int no);

    // 게시물 수정
    void modify(BoardDTO dto);

    // 게시물 삭제
    int remove(int no);

    // dto를 엔티티로 변환하는 메소드
    default Board dtoToEntity(BoardDTO dto) {
        Board entity = Board.builder()
                .no(dto.getNo())
                .title(dto.getTitle())
                .build();
        return entity;
    }

    // 엔티티를 dto로 변환하는 메소드
    default BoardDTO entityToDto(Board entity) {
        BoardDTO dto = BoardDTO.builder()
                .no(entity.getNo())
                .title(entity.getTitle())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}


