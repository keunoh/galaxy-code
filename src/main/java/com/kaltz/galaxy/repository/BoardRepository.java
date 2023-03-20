package com.kaltz.galaxy.repository;


import com.kaltz.galaxy.domain.Board;

import java.util.List;

public interface BoardRepository {

    Board save(Board board);

    Board getById(Long id);

    List<Board> findAll();

    void clear();
}
