package com.qa.SpringTDL.selenium.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.qa.SpringTDL.selenium.page.IndexPage;


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
	
	@After
	public void teardown() {
		this.driver.close();
	}

}
