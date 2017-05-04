package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.controllers.IndexController;

@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
public class ApplicationTest {

	@Autowired
	private WebDriver driver;

	@Test
	public void pageLoads() {
		driver.get("/");
	}
}
