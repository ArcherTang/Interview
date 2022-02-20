package com.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class CoindeskControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetCoindeskApi() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/getCoindeskApi"))
				.andExpect(status().isOk())
				.andReturn();
		System.out.println("testGetUpdateTime:"+ result.getResponse().getContentAsString());
	}

//	@Test
	void testGetUpdateTime() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/getUpdateTime")).andExpect(status().isOk()).andReturn();;

		System.out.println("testGetUpdateTime:"+ result.getResponse().getContentAsString());
	}

//	@Test
	void testGetUSD() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/getUSD")).andExpect(status().isOk()).andReturn();;

		System.out.println("testGetUSD:"+ result.getResponse().getContentAsString());
	}

//	@Test
	void testGetBpi() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/bpi")).andExpect(status().isOk()).andReturn();;

		System.out.println("testGetBpi:"+ result.getResponse().getContentAsString());
	}

//	@Test
	void testCreateBpi() throws Exception {
		MvcResult result = mockMvc.perform(post("/api/bpi")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"code\":\"GBP\",\"symbol\":\"&pound;\",\"description\":\"British Pound Sterling\",\"rateFloat\":\"31837.1619\"}"))
				.andExpect(status().isOk())
				.andReturn();

		System.out.println("testCreateBpi:"+ result.getResponse().getContentAsString());
	}

//	@Test
	void testDeleteBpi() throws Exception {
		testCreateBpi();
		MvcResult result = mockMvc.perform(delete("/api/bpi/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"code\":\"GBP\"}"))
				.andExpect(status().isOk())
				.andReturn();

		System.out.println("testDeleteBpi:"+ result.getResponse().getContentAsString());
	}

//	@Test
	void testUpdateBpi() throws Exception {
		testCreateBpi();
		MvcResult result = mockMvc.perform(put("/api/bpi/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"code\":\"TEST_UPDATE\"}"))
				.andExpect(status().isOk())
				.andReturn();

		System.out.println("testUpdateBpi:"+ result.getResponse().getContentAsString());
	}
}
