package com.sbs.project_instagram.files.dao;

import com.sbs.project_instagram.files.domain.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files, Long> {
}
