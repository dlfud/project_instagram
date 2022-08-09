package com.sbs.project_instagram.answer.service;

import com.sbs.project_instagram.answer.dao.AnswerRepository;
import com.sbs.project_instagram.answer.domain.Answer;
import com.sbs.project_instagram.board.domain.Board;
import com.sbs.project_instagram.util.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public Answer getAnswer(Long id){
        Optional<Answer> answer = this.answerRepository.findById(id);
        if(answer.isPresent()){
            return answer.get();
        }else{
            throw new DataNotFoundException("board not found");
        }
    }

    public void create(Board board, String content){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setBoard(board);
        this.answerRepository.save(answer);
    }

    public void delete(Answer answer){
        this.answerRepository.delete(answer);
    }
}
