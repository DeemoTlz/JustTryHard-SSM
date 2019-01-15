package com.qjh.crud.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.qjh.crud.bean.Student;

/**
 * Spring4 测试时需要servlet3.0的支持
 * @author Arman
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml", "file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class StudentTest {

	@Autowired
	private WebApplicationContext context;
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		Student student = new Student();
		student.setPageNum(1);
		student.setPageSize(10);
		String requestJson = JSONObject.toJSONString(student);
		
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/student/_page").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		System.out.println(result);
	}
	
	@Test
	public void testUpdate() throws Exception {
		Student student = new Student();
		student.setName("唐猪猪侠");
		student.setClassId(4);
		String requestJson = JSONObject.toJSONString(student);
		
		String result = mockMvc.perform(MockMvcRequestBuilders.put("/student/2").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		System.out.println(result);
	}

}
