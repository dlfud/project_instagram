package com.sbs.project_instagram.setting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/setting")
public class SettingController {
    @RequestMapping("/home")
    public String list(){
        return "/setting";
    }

    @RequestMapping("/modify")
    public String modify(){
        return "/setting";
    }

    @RequestMapping("/delete")
    public String delete(){
        return "/setting";
    }


}
