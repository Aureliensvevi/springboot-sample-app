package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest()
@AutoConfigureMockMvc
class AsvApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testxss() throws Exception {
		this.mockMvc.perform(get("/api/xss?id=toto")).andExpect(status().isOk())
				.andExpect(content().string(containsString("toto")));
	}

	@Test
	void testos() throws Exception {
		this.mockMvc.perform(get("/api/os-injection?id=ls")).andExpect(status().isOk());
	}
}
