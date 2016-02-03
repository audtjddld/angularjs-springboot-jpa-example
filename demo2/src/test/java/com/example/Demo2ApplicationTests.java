package com.example;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.json.simple.JSONObject;

import com.Demo2Application;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Demo2Application.class)
@WebAppConfiguration
public class Demo2ApplicationTests {

	@Autowired
	WebApplicationContext wac;
	
	// MockMVC 객체 https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/test/web/servlet/MockMvc.html
	MockMvc mockMvc;
	
	
	@Before
	public void contextLoads() {
		// MockMvc에 Application Context 파일을 주입?
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
				.alwaysDo(MockMvcResultHandlers.print())
				.build();
		
	}

	/**
	 * 사용자 등록
	 * @author 정명성
	 * create date : 2016. 2. 3.
	 * 설명
	 * @throws Exception
	 */
	@Test
	public void test1UserInsert() throws Exception {
		
		JSONObject param = new JSONObject();
		param.put("name", "홍길동");
		param.put("email", "test@test.com");
		
		mockMvc.perform(post("/rest/users")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(param.toJSONString())
				).andExpect(status().is(200));
	}
	
	/**
	 * 사용자 조회
	 * @author 정명성
	 * create date : 2016. 2. 3.
	 * 설명
	 * @throws Exception
	 */
	@Test
	public void test2SelectUser() throws Exception {
		mockMvc.perform(get("/rest/user/1"))
					.andExpect(status().isOk())
					.andExpect(content()
					.contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
					.andReturn()
					.getResponse();
	}
	
	@Test
	public void test3ValidationTest() throws Exception {
		
		JSONObject param = new JSONObject();
		//param.put("name", null);
		param.put("email", "test");
		
		mockMvc.perform(post("/rest/users")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(param.toJSONString())
				).andExpect(status().is(400));
	}
	
}
