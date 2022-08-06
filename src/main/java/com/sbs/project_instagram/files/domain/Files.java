package com.sbs.project_instagram.files.domain;

import com.sbs.project_instagram.board.domain.Board;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    @ManyToOne
    private Board board;
}
