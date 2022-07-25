package com.sbs.project_instagram.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @RequestMapping("/list")
    public String list(){
        return "/board/list";
    }

    @RequestMapping("/setting")
    public String setting(){
        return "redirect:/setting/home";
    }
}
