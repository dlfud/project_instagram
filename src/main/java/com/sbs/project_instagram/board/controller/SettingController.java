package com.sbs.project_instagram.board.controller;

import com.sbs.project_instagram.answer.AnswerForm;
import com.sbs.project_instagram.board.domain.Board;
import com.sbs.project_instagram.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @RequestMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id){
        return "/setting";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        return "/setting";
    }


}
