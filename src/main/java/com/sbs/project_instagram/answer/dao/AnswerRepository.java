package com.sbs.project_instagram.answer.dao;

import com.sbs.project_instagram.answer.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
