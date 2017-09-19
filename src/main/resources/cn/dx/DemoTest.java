package cn.dx;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockServletContext;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import cn.dx.client.controller.IndexController;
//
////在Spring容器环境下运行，可以获取Service、Dao、Controller等内容。
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = MockServletContext.class)
//@WebAppConfiguration
//public class DemoTest {
//
//	private MockMvc mvc;
//
//	@Before
//	public void setUp() throws Exception {
//		mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
//	}
//
//	@Test
//	public void getHello() throws Exception {
//		//判断输出是否相等
//		//		mvc.perform(MockMvcRequestBuilders.get("/didi").accept(MediaType.APPLICATION_JSON))//
//		//				.andExpect(status().isOk())//
//		//				.andExpect(content().string(equalTo("nihao")));
//
//		//打印输出
//		mvc.perform(MockMvcRequestBuilders.get("/didi").accept(MediaType.APPLICATION_JSON))//
//				.andExpect(MockMvcResultMatchers.status().isOk())//
//				.andDo(MockMvcResultHandlers.print())//
//				.andReturn();
//	}
//
//}
