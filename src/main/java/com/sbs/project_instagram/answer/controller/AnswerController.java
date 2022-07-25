package com.sbs.project_instagram.answer.controller;

import com.sbs.project_instagram.answer.service.AnswerService;
import com.sbs.project_instagram.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final BoardService boardService;
    private final AnswerService answerService;


}
