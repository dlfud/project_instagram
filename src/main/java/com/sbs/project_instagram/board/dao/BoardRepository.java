package com.sbs.project_instagram.board.dao;


import com.sbs.project_instagram.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
