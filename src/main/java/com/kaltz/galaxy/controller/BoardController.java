package com.kaltz.galaxy.controller;

import com.kaltz.galaxy.domain.Board;
import com.kaltz.galaxy.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping("/boards/new")
    public String createForm(Model model) {
        model.addAttribute("boardForm", new BoardForm());
        return "board";
    }

    @PostMapping("/boards/new")
    public String create(Model model, BoardForm form) {

        Board board = new Board();
        board.setName(form.getName());

        boardRepository.save(board);

        return "redirect:/boards/new";
    }

    @GetMapping("/boards/list")
    public String list(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "boardList";
    }
}
