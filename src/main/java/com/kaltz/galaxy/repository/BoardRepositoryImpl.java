package com.kaltz.galaxy.repository;

import com.kaltz.galaxy.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardRepositoryImpl implements BoardRepository {

    private final static Map<Long, Board> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Board save(Board board) {
        board.setId(++sequence);
        store.put(board.getId(), board);
        return board;
    }

    @Override
    public Board getById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Board> findAll() {
        return new ArrayList<Board>(store.values());
    }

    @Override
    public void clear() {
        store.clear();
    }
}
