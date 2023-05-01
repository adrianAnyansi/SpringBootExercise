package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

// @EnableJpaRepositories("org.mda.rists.cghub.ws.repository") 
// @WebMvcTest
@WebMvcTest(EmployeeRestController.class)
// @SpringBootTest
@AutoConfigureMockMvc
// @EnableJpaRepositories("com.example.demo")
// @EntityScan("com.example.demo")
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeRestController controller;

	@Test
	public void testAboutPage() throws Exception {
		this.mockMvc.perform(
			get("/about")).andDo(print())
			.andExpect(status().isOk());
	}

	// TODO: Test per CRUD method
	// remember persistance counts
}
