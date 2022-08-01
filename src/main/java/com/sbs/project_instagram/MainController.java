package com.sbs.project_instagram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String main(){
        return "redirect:/board/list";
    }

    @RequestMapping("/modal")
    public String modal(){
        return "/modal";
    }

    @RequestMapping("/post")
    public String asd(){
        return "/post";
    }
}
