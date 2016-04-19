/**
 * 
 */
package com.example.restapi;

import java.nio.charset.Charset;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author 정명성
 * create date : 2016. 2. 4.
 * com.example.restapi.RemoteRestAPITest.java
 */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RemoteRestAPITest {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	RestTemplate restTemplate = new TestRestTemplate();
	
	static String access_token;
	
	HttpHeaders headers;
	
	
	@Before
	public void start() {
		// header 셋팅
		headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
	}
	
	/**
	 * RestTemplate를 이용한 API 점검
	 * @author 정명성
	 * create date : 2016. 2. 4.
	 * 설명
	 * @throws Exception
	 */
	//@Test
	public void test1RestTemplate() throws Exception {

	
		// 클라이언트 계정 셋팅
		JSONObject param = new  JSONObject();
		
		param.put("clientId", "client_id");
		param.put("secret", "client_secret");
		param.put("serialNo", "number");
		param.put("userId", "uid");
		param.put("password", "password");

		
		HttpEntity entity = new HttpEntity(param.toString(), headers);
		
		String result = restTemplate.postForEntity("http://url:port",
									entity,
									String.class).getBody();
		
		JSONParser parser = new JSONParser();
		JSONObject parsing = (JSONObject)parser.parse(result);
		
		// 토큰  저장
		access_token = parsing.get("accessToken").toString();
		
		assertNotNull(access_token);
		
		logger.info(parsing.toJSONString());
	}
	
	/**
	 * 장비 리스트 가져오기
	 * @author 정명성
	 * create date : 2016. 2. 4.
	 * 설명
	 * @throws Exception
	 */
	//@Test
	public void test2GetMachines() throws Exception {
		
		assertNotNull(access_token);
		
		// 인증 토큰 셋팅
		headers.set("Authorization", access_token);
		
		// 결과
		String result = restTemplate.exchange("http://url:port",
												HttpMethod.GET ,
												new HttpEntity(headers), 
												String.class).getBody();
		
		logger.info(result);
	}
}
