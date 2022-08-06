package com.sbs.project_instagram.files.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilesController {
    @GetMapping("/multi-file")
    public String showMultiForm(){
        return "/board_form";
    }
}
