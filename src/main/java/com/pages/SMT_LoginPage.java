package com.pages;


import com.BasePackage.Base_Class;
import org.testng.*;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.Utility.Log;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
//import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

import net.bytebuddy.description.annotation.AnnotationList.Empty;

import org.testng.Assert;

public class SMT_LoginPage extends Base_Class
{
	
	private static By Btn_Continue_Config = By.xpath("//div/button[@class=\"btn btn-primary yellow btn-round\"]");
	private static By text_ConfigChk = By.xpath("//div/h1[text()='Configuration Check']");
	private static By text_SMT = By.xpath("//div/h2[text()='SALES MANAGEMENT TOOL']");
	private static By input_UserName = By.xpath("//input[@id='mat-input-2']");
	private static By input_Password = By.id("mat-input-3");
	private static By Btn_Signin = By.xpath("//div/button[@class='btn btn-primary px-5 py-3 login-btn']");
	
	
	
	// private static By Text_Agree_andEmail = By.xpath("//body/form[@id='aspnetForm']/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]");
	//Scanner sc= new Scanner(System.in);  
	
	public void TC_01_Validate_SMTtitle_Text(String Value,String Text_input) throws Exception {
		
				if (Value.equalsIgnoreCase("SMTtitle_Text")) {
					
				String SMTTitle= driver.getTitle();
					
					//String Text_acknowledge = driver.findElement(SMTTitle).getText().replaceAll("\n+", " ").trim();
					Assert.assertEquals(SMTTitle.toUpperCase(),Text_input.trim().toUpperCase(),"SMTWeb title text doesnot matche");

					ExtentTestManager.getTest().log(Status.PASS, "SMTWeb title text matches successfully");
					Log.info("SMTWeb title text matches successfully");
				 

				}
		
	}	

	public void TC_02_Validate_Text_ConfigChek_CCpop(String Value,String Text_input) throws Exception {
		
		if (Value.equalsIgnoreCase("ConfigChek_CCpop")) {

			Thread.sleep(1000);
			String text_configchk = driver.findElement(text_ConfigChk).getText();
		
			Assert.assertEquals(text_configchk.toUpperCase(),Text_input.trim().toUpperCase(),"Configure Check text on Configure Check doesnot matches");

			ExtentTestManager.getTest().log(Status.PASS, "Configure Check text on Configure Check  matches successfully");
			Log.info("Configure Check text on Configure Check  matches successfully");

		}
		
	}

	
public void TC_03_Validate_Click_btn_Contine_CCpop(String Value,String Text_input) throws Exception {
		
		if (Value.equalsIgnoreCase("Click_btn_Contine_CCpop")) {

			Thread.sleep(1000);
			MoveToElement(Btn_Continue_Config);
			click(Btn_Continue_Config);
			
			ExtentTestManager.getTest().log(Status.PASS, "Clicked successfully on 'Continue' button of Configure Check popup");
			Log.info("Clicked successfully on 'Continue' button of Configure Check popup");

		}
		
	}



}