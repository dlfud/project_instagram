package com.sbs.project_instagram.board.service;

import com.sbs.project_instagram.board.dao.BoardRepository;
import com.sbs.project_instagram.board.domain.Board;
import com.sbs.project_instagram.util.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;

    public List<Board> getList(){
        return boardRepository.findAll();
    }

    public Board getQuestion(Long id) {
        Optional<Board> opQuestion = this.boardRepository.findById(id);
        if(opQuestion.isPresent()){
            Board question = opQuestion.get();
            //조회수 늘리기
            question.setViewCount(question.getViewCount() + 1);
            //바뀐 db저장
            this.boardRepository.save(question);
            return question;
        }
        else{
            throw new DataNotFoundException("question not Found");
        }
    }

    public void create(String title, String content){
        Board question = new Board();
        question.setTitle(title);
        question.setContent(content);
        question.setCreateDate(LocalDateTime.now());
        this.boardRepository.save(question);
    }

    public Page<Board> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.boardRepository.findAll(pageable);
    }

}
