package com.qa.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.IndexPage;


public class IndexTest {
	
	private WebDriver driver;
	
	@Before
	public void setup () {
		
		ChromeOptions opts = new ChromeOptions();
		opts.setHeadless(false);
		
		this.driver = new ChromeDriver(opts);
		
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		this.driver.get("http://127.0.0.1:5500/TDL%20Project/Front-end/html/index.html");
			
	}
	
	@Test
	public void titleTest() {
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		
		assertEquals("Home page",indexPage.getTitle());
	}
	
	@Test
	public void homeLink() {
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		
		indexPage.clickHome();
		assertEquals("Home page",indexPage.getTitle());
		
	}
	
	@Test
	public void buttonFunction() throws InterruptedException {
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		String name = "task name";
		String desc = "task description";
		String time = "5";
		indexPage.enterPost1(name);
		indexPage.enterPost2(desc);
		indexPage.enterPost3(time);
		indexPage.clickPostBtn();
		Thread.sleep(50);
		assertTrue(indexPage.getPostTable().contains("task name task description 5"));
		indexPage.clickGetAll();
		Thread.sleep(50);
		assertTrue(indexPage.getGetAllTable().contains("task name task description 5"));
		indexPage.enterPutId("1");
		indexPage.enterPut1("new name");
		indexPage.enterPut2("new desc");
		indexPage.enterPut3("15");
		indexPage.clickPutBtn();
		Thread.sleep(50);
		assertTrue(indexPage.getPutTable().contains("new name new desc 15"));
		indexPage.enterDeleteId("1");
		indexPage.clickDeleteBtn();
		Thread.sleep(50);
		assertEquals("data with id: 1 deleted",indexPage.getDeletePara());

	}
	
	@After
	public void teardown() {
		this.driver.close();
	}

}
