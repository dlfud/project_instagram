package com.sbs.project_instagram.answer.domain;

import com.sbs.project_instagram.board.domain.Board;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    private Boolean replyLike;

    @ManyToOne
    private Board board;

}
