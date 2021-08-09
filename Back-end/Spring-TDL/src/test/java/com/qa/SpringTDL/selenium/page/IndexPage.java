package com.qa.SpringTDL.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
	public final String url ="http://127.0.0.1:5500/TDL%20Project/Front-end/html/index.html";
	
	@FindBy(xpath="/html/body/h1")
	private WebElement title;
	
	@FindBy(xpath="/html/body/nav/a[1]")
	private WebElement homeBtn;
	
	@FindBy(xpath="/html/body/nav/a[2]")
	private WebElement page2Btn;
	
	@FindBy(id="getallbtn")
	private WebElement getAllBtn;
	
	@FindBy(id="getalltable")
	private WebElement getAllTable;
	
	@FindBy(id="getonebtn")
	private WebElement getOneBtn;
	
	@FindBy(id="getoneid")
	private WebElement getOneId;
	
	@FindBy(id="getonetable")
	private WebElement getOneTable;
	
	@FindBy(id="postbtn")
	private WebElement postBtn;
	
	@FindBy(id="post1")
	private WebElement post1;
	
	@FindBy(id="post2")
	private WebElement post2;
	
	@FindBy(id="posttable")
	private WebElement postTable;
	
	@FindBy(id="putbtn")
	private WebElement putBtn;
	
	@FindBy(id="putid")
	private WebElement putId;
	
	@FindBy(id="put1")
	private WebElement put1;
	
	@FindBy(id="put2")
	private WebElement put2;
	
	@FindBy(id="puttable")
	private WebElement putTable;
	
	@FindBy(id="deletebtn")
	private WebElement deleteBtn;
	
	@FindBy(id="deleteid")
	private WebElement deleteId;
	
	@FindBy(id="deletepara")
	private WebElement deletePara;
	
	public String getTitle() {
		return title.getText();
	}
	
	public void clickHome() {
		homeBtn.click();
	}
	
	public void clickPage2() {
		page2Btn.click();
	}
	
	public void clickGetAll() {
		getAllBtn.click();
	}
	
	public String getGetAllTable() {
		return getAllTable.getText();
	}
	
	public void clickGetOneBtn() {
		getOneBtn.click();
	}
	
	public void enterGetOneId(String string) {
		getOneId.sendKeys(string);
	}
	
	public String getGetOneTable() {
		return getOneTable.getText();
	}
	
	public void clickPostBtn() {
		postBtn.click();
	}
	
	public void enterPost1(String string) {
		post1.sendKeys(string);
	}
	
	public void enterPost2(String string) {
		post2.sendKeys(string);
	}
	
	public String getPostTable() {
		return postTable.getText();
	}
	
	public void clickPutBtn() {
		putBtn.click();
	}
	
	public void enterPutId(String string) {
		putId.sendKeys(string);
	}
	
	public void enterPut1(String string) {
		put1.sendKeys(string);
	}
	
	public void enterPut2(String string) {
		put2.sendKeys(string);
	}
	
	public String getPutTable() {
		return putTable.getText();
	}
	
	public void clickDeleteBtn() {
		deleteBtn.click();
	}
	
	public void enterDeleteId(String string) {
		deleteId.sendKeys(string);
	}

}
