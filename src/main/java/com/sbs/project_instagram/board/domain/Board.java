package com.sbs.project_instagram.board.domain;

import com.sbs.project_instagram.answer.domain.Answer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private Boolean onOff;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}
