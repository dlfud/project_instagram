package com.sbs.project_instagram.files.service;

import com.sbs.project_instagram.board.service.BoardService;
import com.sbs.project_instagram.files.dao.FilesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilesService {
    private final FilesRepository filesRepository;
    private final BoardService boardService;


}
