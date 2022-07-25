package com.sbs.project_instagram.board.controller;

import com.sbs.project_instagram.answer.AnswerForm;
import com.sbs.project_instagram.board.BoardForm;
import com.sbs.project_instagram.board.domain.Board;
import com.sbs.project_instagram.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

    @RequestMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page){
        Page<Board> paging = this.boardService.getList(page);
        model.addAttribute("paging", paging);
        return "/board_list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id, AnswerForm answerForm){
        Board board = this.boardService.getBoard(id);
        model.addAttribute("board", board);
        return "/board_detail";
    }

    @GetMapping("/create")
    public String boardCreate(BoardForm boardForm){
        return "/board_form";
    }

    @PostMapping("/create")
    public String boardCreate(@Valid BoardForm boardForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/board_form";
        }
        this.boardService.create(boardForm.getTitle(), boardForm.getContent());
        return "redirect:/board/list";
    }
}
