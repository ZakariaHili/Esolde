package com.HILI.ESolde;

import static org.junit.Assert.*;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestJPA {
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext app=
					new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(e.getMessage(),false);
		}
	}
}