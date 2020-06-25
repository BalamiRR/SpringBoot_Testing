package com.example.unittesting.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.example.unittesting.model.Employee;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value=Employee.class)
class TestControllerUnit {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void sansliK() throws Exception {
	
		String bookInJson = "{\"id\":1,\"firstName\":\"Andrea\",\"lastName\":\"Pirlo\",\"email\":\"pirlo@gmail.com\"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<>(bookInJson,headers);
		
		System.out.println(entity);
	}
	
	@Test
	public void sansliS() throws JSONException {
		JSONObject actual = new JSONObject();
		actual.put("id", 1);
		actual.put("firstName", "Andrea");
		actual.put("lastName", "Pirlo");
		
		JSONAssert.assertEquals("{id:1}", actual, false); 					//Pass, extended fields doesn't matter
		JSONAssert.assertEquals("{firstName:\"Andrea\"}", actual, false);		//Pass
		JSONAssert.assertEquals("{firstName:\"Andrea\", id:1}", actual, false);//Pass
		JSONAssert.assertEquals("{firstName:Andrea, id:1}", actual, false);		//Pass
		JSONAssert.assertEquals("{id:1, lastName:'Pirlo'}", actual, false);	
		JSONAssert.assertEquals("{id:1, firstName:\"Andrea\", lastName:\"Pirlo\"}", actual, true);
	}
	
	
	
	@Test
	public void testingss() throws Exception {
		mockMvc.perform(get("/list"))
			   .andExpect(status().is(404))
			   .andDo(print());	
	}
	
//	@Test
//	public void testGet() {
//		Employee empl = new Employee();
//		empl.setId(1);
//		when(serviceUnitImpl.findById(1)).thenReturn(empl);
//		
//		Employee employee = controllerUnit.findById(1);
//		
//		verify(serviceUnitImpl).findById(1);
//		
//		assertEquals(1, employee.getId());
//	}
	
	@Test
	public void findingAll() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/list")
				.accept(MediaType.APPLICATION_JSON);
		
		String json = "{\'id\':1,\'firstName\':\'Andrea\',\'lastName\':\'Pirlo\',\'email\':\'pirlo@gmail.com\'}";
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(content().json(json))
				.andReturn();
		
		System.out.println(result);
	}

	@Test
	public void findAllisNotFound() throws Exception {
		String bookInJson = "{\"id\":1,\"firstName\":\"Andrea\",\"lastName\":\"Pirlo\",\"email\":\"pirlo@gmail.com\"}";
	
		this.mockMvc
			.perform(get("/list")
			.accept(MediaType.TEXT_PLAIN))
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void findAllis() throws Exception {
		this.mockMvc
			.perform(get("/list")
			.accept(MediaType.TEXT_PLAIN))
			.andExpect(status().is(404));
	}
	
	@Test
	public void findAllisOk() throws Exception {
		
		String json = "{\'id\':1,\'firstName\':\'Andrea\',\'lastName\':\'Pirlo\',\'email\':\'pirlo@gmail.com\'}";
		
		this.mockMvc
			.perform(get("/list/{id}")
			.accept(json))
			.andExpect(status().isOk());
	}
	
	
	
	
	
	
	
}