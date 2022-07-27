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

    private final BoardRepository boardRepository;

    public List<Board> getList(){
        return this.boardRepository.findAll();
    }

    public Board getBoard(Long id){
        Optional<Board> board = this.boardRepository.findById(id);
        if(board.isPresent()){
            return board.get();
        }else{
            throw new DataNotFoundException("board not found");
        }
    }

    public void create(String title, String content){
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setCreateDate(LocalDateTime.now());
        this.boardRepository.save(board);
    }

    public Page<Board> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.boardRepository.findAll(pageable);
    }

    public void delete(Board board){
        this.boardRepository.delete(board);
    }

    public void modify(Board board, String title, String content, Boolean onOff){
        board.setTitle(title);
        board.setContent(content);
        board.setModifyDate(LocalDateTime.now());
        board.setOnOff(onOff);
        this.boardRepository.save(board);
    }

}
