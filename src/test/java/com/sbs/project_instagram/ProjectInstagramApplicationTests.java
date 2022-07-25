package com.sbs.project_instagram;

import com.sbs.project_instagram.board.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectInstagramApplicationTests {

	private BoardService boardService;

	@Test
	void testJpa() {
		for (int i = 1; i <= 300; i++) {
			String title = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
			this.boardService.create(title, content);
		}
	}

}
