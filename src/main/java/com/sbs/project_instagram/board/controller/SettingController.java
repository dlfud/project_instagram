package com.sbs.project_instagram.board.controller;

import com.sbs.project_instagram.answer.AnswerForm;
import com.sbs.project_instagram.board.BoardForm;
import com.sbs.project_instagram.board.domain.Board;
import com.sbs.project_instagram.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/setting")
@RequiredArgsConstructor
public class SettingController {
    private final BoardService boardService;

    @RequestMapping("/{id}")
    public String list(Model model, @PathVariable("id") Long id, AnswerForm answerForm){
        Board board = this.boardService.getBoard(id);
        model.addAttribute("board", board);
        return "/setting";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        Board board = this.boardService.getBoard(id);
        this.boardService.delete(board);
        return "redirect:/board/list";
    }


    @GetMapping("/modify/{id}")
    public String modify(Model model, @PathVariable("id") Long id, BoardForm boardForm){
        Board board = this.boardService.getBoard(id);
        boardForm.setTitle(boardForm.getTitle());
        boardForm.setContent(boardForm.getContent());
        model.addAttribute("board", board);
        return "/modify";
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id, @Valid BoardForm boardForm, BindingResult bindingResult){
        Board board = this.boardService.getBoard(id);
        if(bindingResult.hasErrors()){
            return "/modify";
        }
        this.boardService.modify(board, boardForm.getTitle(), boardForm.getContent());
        return String.format("redirect:/board/detail/%s", id);
    }

}
