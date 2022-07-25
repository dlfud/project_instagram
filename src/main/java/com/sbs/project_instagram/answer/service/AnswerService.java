package com.sbs.project_instagram.answer.service;

import com.sbs.project_instagram.answer.dao.AnswerRepository;
import com.sbs.project_instagram.answer.domain.Answer;
import com.sbs.project_instagram.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Board board, String content){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setBoard(board);
        this.answerRepository.save(answer);
    }
}
