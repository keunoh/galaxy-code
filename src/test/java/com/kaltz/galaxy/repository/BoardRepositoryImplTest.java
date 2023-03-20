package com.kaltz.galaxy.repository;

import com.kaltz.galaxy.domain.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BoardRepositoryImplTest {

    BoardRepository boardRepository = new BoardRepositoryImpl();

    @BeforeEach
    void beforeEach() {
        boardRepository.clear();
    }

    @Test
    void save() {
        //given
        Board board = new Board("게시물1");

        //when
        Board savedBoard = boardRepository.save(board);


        //then
        Board findBoard = boardRepository.getById(savedBoard.getId());
        assertThat(findBoard).isEqualTo(board);
    }

    @Test
    void findAll() {
        //given
        Board board1 = new Board("게시물1");
        Board board2 = new Board("게시물2");

        boardRepository.save(board1);
        boardRepository.save(board2);

        //when
        List<Board> result = boardRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

}