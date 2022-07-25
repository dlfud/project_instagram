package com.sbs.project_instagram.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @RequestMapping("/list")
    public String list(){
        return "/board/list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id){
        return "board_detail";
    }

    @RequestMapping("/setting")
    public String setting(){
        return "redirect:/setting/home";
    }
}
