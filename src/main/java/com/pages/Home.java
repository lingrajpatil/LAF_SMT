package com.pages;

import java.awt.AWTException;
import java.util.List;

import com.Utility.Log;

//import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;
import org.testng.Assert;
public class Home extends Base_Class {

	private static By Join_now_button = By.xpath("//div[@class='d-flex align-items-center nav-menu-list']/div/a[@title='JOIN NOW']");
	private static By Join_now_btn_CST = By.xpath("//div[@class='d-flex align-items-center nav-menu-list']/div/a[@href='/JoinNow/Default.aspx']");
			//div[@id='lnkJoinNow']/a[@href='/JoinNow/Default.aspx']
	
//	private static By about = By.xpath("//body/form[@id='aspnetForm']/div[3]/div[2]/div[14]/footer[1]/div[3]/div[1]/div[2]/ul[1]/li[6]/a[1]");

	private static By LAF_logo=By.xpath("//body/form[@id='aspnetForm']/div[3]/div[1]/nav[1]/div[3]/div[1]/a[1]/img[1]");
	
	private static By FreePass_top_button = By.xpath("//div[@class='d-flex align-items-center nav-menu-list']/div/a[@title='FREE PASS']");
	private static By FreePass_mid = By.xpath("//div[@class='btn free-pass']/a[@title='FREE PASS']");
	private static By FreePass_bottom = By.xpath("//div[@class=' col-lg-2 d-flex justify-content-around flex-column pass-join']/div/a[@title='FREE PASS']");
	private static By About = By.xpath("//a[@class='drop-down-arrow'][contains(text(),'About')]");
	private static By Carer_Opp = By.xpath("//div[@class='nav-drop-down']//a[contains(text(),'Career Opportunities')]");
	private static By play_pause = By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-launcher:nth-child(2) form.ae-form:nth-child(2) div.content div.row:nth-child(6) div.carousel.slide.carousel-fade.d-none.d-md-block:nth-child(1) div.container.d-none.d-md-block.carousel-play-btn div.d-flex.justify-content-center.align-items-center > a.btn.btn-secondary");

	private static By Locations = By.xpath("//div[@class='d-flex align-items-center nav-menu-list']//a[contains(text(),'Locations')]");

	private static By Start_new_search = By.id("ctl00_MainContent_LinkButton1");
	private static By Login = By.xpath("//a[@id='ctl00_GlobalHeader_lnkLogin']/img");
	private static By Careers_link = By.xpath("//div[@class='d-flex align-items-center nav-menu-list']//a[contains(text(), 'Careers')]");
	
	private static By jobs_rows = By.xpath("//div[@class='d-flex align-items-center nav-menu-list']//a[contains(text(), 'Careers')]");
	private static By jobtitles = By.xpath("//div[@class='jobTitle']");
	private static By jobdes = By.xpath("//div[@class='desc-ta']");
	
	
	
	//Verify 'JOIN NOW' button
	
	
	
	public void Validate_joinnow_button(String Value) throws Exception {
		
				if (Value.equalsIgnoreCase("Joinnow")) {
		
					Element_isdisplayed(Join_now_button);
				
					ExtentTestManager.getTest().log(Status.PASS, "JOIN NOW button is displayed successfully");
					Log.info("JOIN NOW button is displayed successfully");
			
				}

			}
	

	public void Validate_joinnow_btn_CST(String Value) throws Exception {
		
				if (Value.equalsIgnoreCase("Validate_joinnow_btn_CST")) {
		
					Element_isdisplayed(Join_now_btn_CST);
				
					ExtentTestManager.getTest().log(Status.PASS, "JOIN NOW button is displayed successfully");
					Log.info("JOIN NOW button is displayed successfully");
			
				}

			}
	

	public void Navigate_to_Joinnow_page(String Value) throws Exception {
		if (Value.equalsIgnoreCase("Navigate_to_Joinnow_page")) {
			
//		Element_isdisplayed(play_pause);
//		MoveToElement(play_pause);
//		click(play_pause);
		Validate_joinnow_btn_CST("Validate_joinnow_btn_CST");
//		Thread.sleep(200);
//		Element_isdisplayed(Login);	
//		if (driver.findElement(Join_now_button).isDisplayed()) click(Join_now_button);
//		else click(Join_now_button_m);
		
		click(Join_now_btn_CST);
//		Thread.sleep(500);
//		Element_isdisplayed(About);
		ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on Join now button");
		Log.info("Successfully clicked on Join now button");
//		Mouse_hover(About);
//		Element_isdisplayed(Carer_Opp);
//		ExtentTestManager.getTest().log(Status.PASS, "Career opportunities option is displayed successfully under About dropdown in homepage");
//		Log.info("Career opportunities option is displayed successfully under About dropdown in homepage");
//		
//		click(Carer_Opp);
//		ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on Career opportunities option under About dropdown in homepage");
//		Log.info("Successfully clicked on Career opportunities option under About dropdown in homepage");
		Thread.sleep(200);
		String t=driver.getTitle();
		Assert.assertEquals(t.toUpperCase().trim(), "Club Studio Fitness | Gym Membership | Health and Fitness Center".toUpperCase().trim(), "Join now title not validated and not navigatd to Join now page");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully navigated to Join now page: "+t);
		Log.info("Successfully navigated to Join now page: "+t);
		
//		Employment e= new Employment();
//		e.play_video();
		
		}
	}
	
	

	public void Validate_Freepass_button(String Value) throws Exception {
		
		if (Value.equalsIgnoreCase("Free_pass")) {

			Element_isdisplayed(FreePass_top_button);
		
			ExtentTestManager.getTest().log(Status.PASS, "FreePass_top_button validation successful");
			Log.info("FreePass_top_button validation successful");

		}
	
	}
	
	
	public void Validate_About_dropdown(String Value) throws Exception {
		
		if (Value.equalsIgnoreCase("About_dropdown")) {
			
			Element_isdisplayed(Login);	
			click(Login);
//			Thread.sleep(200);
			Thread.sleep(200);
			Element_isdisplayed(About);
			ExtentTestManager.getTest().log(Status.PASS, "About dropdown displayed successful");
			Log.info("About dropdown displayed successful");
			Mouse_hover(About);
			Element_isdisplayed(Carer_Opp);
			ExtentTestManager.getTest().log(Status.PASS, "Career opportunities option is displayed successfully under About dropdown in homepage");
			Log.info("Career opportunities option is displayed successfully under About dropdown in homepage");
			Thread.sleep(200);
		}

	}	


	public void Validate_About_dd_CO_option_CSC(String Value) throws Exception {
		
		if (Value.equalsIgnoreCase("Validate_About_dd_CO_option_CSC")) {
			
			Element_isdisplayed(Login);	
			click(Login);
//			Thread.sleep(200);
			Thread.sleep(200);
			Element_isdisplayed(About);
			ExtentTestManager.getTest().log(Status.PASS, "About dropdown displayed successful");
			Log.info("About dropdown displayed successful");
			Mouse_hover(About);
			Element_isdisplayed(Carer_Opp);
			ExtentTestManager.getTest().log(Status.PASS, "Career opportunities option is displayed successfully under About dropdown in homepage");
			Log.info("Career opportunities option is displayed successfully under About dropdown in homepage");
			Thread.sleep(200);
		}

	}	

	
	
	
	public void Navigate_to_Emplyoment_page(String Value) throws Exception {
		if (Value.equalsIgnoreCase("Nav_to_Employment_page")) {
			
//		Element_isdisplayed(play_pause);
//		MoveToElement(play_pause);
//		click(play_pause);
		Thread.sleep(200);
		Element_isdisplayed(Login);	
		click(Login);
		Thread.sleep(500);
		Element_isdisplayed(About);
		ExtentTestManager.getTest().log(Status.PASS, "About dropdown displayed successful");
		Log.info("About dropdown displayed successful");
		Mouse_hover(About);
		Element_isdisplayed(Carer_Opp);
		ExtentTestManager.getTest().log(Status.PASS, "Career opportunities option is displayed successfully under About dropdown in homepage");
		Log.info("Career opportunities option is displayed successfully under About dropdown in homepage");
		
		click(Carer_Opp);
		ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on Career opportunities option under About dropdown in homepage");
		Log.info("Successfully clicked on Career opportunities option under About dropdown in homepage");
		Thread.sleep(500);
		String t=driver.getTitle();
		Assert.assertEquals(t.toUpperCase().trim(), "LA Fitness | Gym Jobs | Fitness Employment Opportunities".toUpperCase().trim(), "Emplyoment_page title not validated and not navigatd to Emplyoment_page");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully navigated to Fitness Career Opportunities/Employment page: "+t);
		Log.info("Successfully navigated to Fitness Career Opportunities/Employment page: "+t);
		
//		Employment e= new Employment();
//		e.play_video();
		
		}
	}


	public void Navigate_to_Emplyoment_page_ESP(String Value) throws Exception {
		if (Value.equalsIgnoreCase("Navigate_to_Emplyoment_page_ESP")) {
			
//		Element_isdisplayed(play_pause);
//		MoveToElement(play_pause);
//		click(play_pause);
		Thread.sleep(200);
		Element_isdisplayed(Login);	
		click(Login);
		Thread.sleep(500);
		Element_isdisplayed(About);
		ExtentTestManager.getTest().log(Status.PASS, "About dropdown displayed successful");
		Log.info("About dropdown displayed successful");
		Mouse_hover(About);
		Element_isdisplayed(Carer_Opp);
		ExtentTestManager.getTest().log(Status.PASS, "Career opportunities option is displayed successfully under About dropdown in homepage");
		Log.info("Career opportunities option is displayed successfully under About dropdown in homepage");
		click(Carer_Opp);
		ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on Career opportunities option under About dropdown in homepage");
		Log.info("Successfully clicked on Career opportunities option under About dropdown in homepage");
		Thread.sleep(500);
		String t=driver.getTitle();
		Assert.assertEquals(t.toUpperCase().trim(), "Esporta Fitness | Gym Jobs | Fitness Employment Opportunities".toUpperCase().trim(), "Emplyoment page title not validated and not navigatd to Emplyoment_page");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully navigated to Esporta Fitness Career Opportunities/Employment page: "+t);
		Log.info("Successfully navigated to Esporta Fitness Career Opportunities/Employment page: "+t);
		
//		Employment e= new Employment();
//		e.play_video();
		
		}
	}
	


	public void Navigate_to_Emplyoment_CitySportpage(String Value) throws Exception {
		if (Value.equalsIgnoreCase("Navigate_to_Emplyoment_CitySportpage")) {
			
//		Element_isdisplayed(play_pause);
//		MoveToElement(play_pause);
//		click(play_pause);
		Thread.sleep(200);
		Element_isdisplayed(Login);	
		click(Login);
		Thread.sleep(500);
		Element_isdisplayed(About);
		ExtentTestManager.getTest().log(Status.PASS, "About dropdown displayed successful");
		Log.info("About dropdown displayed successful");
		Mouse_hover(About);
		Element_isdisplayed(Carer_Opp);
		ExtentTestManager.getTest().log(Status.PASS, "Career opportunities option is displayed successfully under About dropdown in homepage");
		Log.info("Career opportunities option is displayed successfully under About dropdown in homepage");
		
		click(Carer_Opp);
		ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on Career opportunities option under About dropdown in homepage");
		Log.info("Successfully clicked on Career opportunities option under About dropdown in homepage");
		Thread.sleep(200);
		String t=driver.getTitle();
		Assert.assertEquals(t.toUpperCase().trim(), "CITY SPORTS CLUB | GYM JOBS | FITNESS EMPLOYMENT OPPORTUNITIES".toUpperCase().trim(), "Emplyoment_page title not validated and not navigatd to Emplyoment_page");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully navigated to City Sports Fitness Career Opportunities/Employment page: "+t);
		Log.info("Successfully navigated to City Sports Fitness Career Opportunities/Employment page: "+t);
		
//		Employment e= new Employment();
//		e.play_video();
		
		}
	}
	



	public void Validate_Navigate_to_CO_page_CSC(String Value) throws Exception {
		if (Value.equalsIgnoreCase("Validate_Navigate_to_CO_page_CSC")) {
			
//		Element_isdisplayed(play_pause);
//		MoveToElement(play_pause);
//		click(play_pause);
		Thread.sleep(200);
		Element_isdisplayed(Login);	
		click(Login);
		Thread.sleep(500);
		Element_isdisplayed(About);
		ExtentTestManager.getTest().log(Status.PASS, "About dropdown displayed successful");
		Log.info("About dropdown displayed successful");
		Mouse_hover(About);
		Element_isdisplayed(Carer_Opp);
		ExtentTestManager.getTest().log(Status.PASS, "Career opportunities option is displayed successfully under About dropdown in homepage");
		Log.info("Career opportunities option is displayed successfully under About dropdown in homepage");
		
		click(Carer_Opp);
		ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on Career opportunities option under About dropdown in homepage");
		Log.info("Successfully clicked on Career opportunities option under About dropdown in homepage");
		Thread.sleep(500);
		String t=driver.getTitle();
		Assert.assertEquals(t.toUpperCase().trim(), "City Sports Club | Gym Jobs | Fitness Employment Opportunities".toUpperCase().trim(), "Emplyoment page title not validated and not navigatd to Emplyoment page");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully navigated to Career Opportunities page: "+t);
		Log.info("Successfully navigated to Career Opportunitie page: "+t);
		
//		Employment e= new Employment();
//		e.play_video();
		
		}
	}
	

	
	
	public void Validate_Careers_link(String Value) throws Exception {
		
				if (Value.equalsIgnoreCase("Validate_Careers_link")) {
		
					Element_isdisplayed(Careers_link);
				
					ExtentTestManager.getTest().log(Status.PASS, "Careers Link displayed successfully");
					Log.info("Careers Link displayed successfully");
			
				}

			}
	

	public void Navigate_to_Careers_page(String Value) throws Exception {
		if (Value.equalsIgnoreCase("Navigate_to_Careers_page")) {
			
//		Element_isdisplayed(play_pause);
//		MoveToElement(play_pause);
//		click(play_pause);
//		Thread.sleep(200);
		Element_isdisplayed(Careers_link);	
		click(Careers_link);
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on Careers link in homepage");
		Log.info("Successfully clicked on Careers link in homepage");
//		Thread.sleep(200);
		String t=driver.getTitle();
		Assert.assertEquals(t.toUpperCase().trim(), "Club Studio Fitness | Gym Jobs | Fitness Employment Opportunities".toUpperCase().trim(), "Careers page title not validated and not navigatd to Careers page");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully navigated to "+t+" page");
		Log.info( "Successfully navigated to "+t+" page");
		
//		Employment e= new Employment();
//		e.play_video();
		
		}
	}
	
	
public void TC_01_Validate_Freepass_button(String Value) throws Exception {
		
		if (Value.equalsIgnoreCase("Free_pass")) {
			

			Element_isdisplayed(FreePass_top_button);
		
			ExtentTestManager.getTest().log(Status.PASS, "FreePass_top_button validation successful");
			Log.info("FreePass_top_button validation successful");

		}
	
	}
	
	

public void Validate_Locations_link(String Value) throws Exception {
	
			if (Value.equalsIgnoreCase("Validate_Locations_link")) {
	
				Element_isdisplayed(Locations);
			
				ExtentTestManager.getTest().log(Status.PASS, "Locations Link displayed successfully");
				Log.info("Locations Link displayed successfully");
		
			}

		}


public void Navigate_to_Locations_page(String Value, String page_title) throws Exception {
	if (Value.equalsIgnoreCase("Navigate_to_Locations_page")) {
		
	Validate_Locations_link("Validate_Locations_link");
		
	click(Locations);
	
	Thread.sleep(200);
	ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on Locations link");
	Log.info("Successfully clicked on Locations link");
	
		if(driver.getTitle().trim().equalsIgnoreCase(page_title.trim())) {
//		Assert.assertEquals(driver.getTitle().toUpperCase().trim(), page_title.toUpperCase(),"Not navigated to "+page_title+" page");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully navigated to "+page_title+" page");
		Log.info("Successfully navigated to to "+page_title+" page");
		}else if (driver.findElements(Start_new_search).size()==1) {
			click(Start_new_search);
			Thread.sleep(200);
			Assert.assertEquals(driver.getTitle().toUpperCase().trim(), page_title.toUpperCase(),"Not navigated to "+page_title+" page");
			ExtentTestManager.getTest().log(Status.PASS, "Successfully navigated to "+page_title+" page");
			Log.info("Successfully navigated to to "+page_title+" page");
			
		}
		else {
			throw new Exception("Not navigated to "+page_title+" page");
		}
		
		
	
	
	
	
	
	
//	Element_isdisplayed(About);
//	ExtentTestManager.getTest().log(Status.PASS, "About dropdown displayed successful");
//	Log.info("About dropdown displayed successful");
//	Mouse_hover(About);
//	Element_isdisplayed(Carer_Opp);
//	ExtentTestManager.getTest().log(Status.PASS, "Career opportunities option is displayed successfully under About dropdown in homepage");
//	Log.info("Career opportunities option is displayed successfully under About dropdown in homepage");
//	
//	click(Carer_Opp);
//	ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on Career opportunities option under About dropdown in homepage");
//	Log.info("Successfully clicked on Career opportunities option under About dropdown in homepage");
//	Thread.sleep(200);
//	String t=driver.getTitle();
//	Assert.assertEquals(t.toUpperCase().trim(), "LA Fitness | Gym Jobs | Fitness Employment Opportunities".toUpperCase().trim(), "Emplyoment_page title not validated and not navigatd to Emplyoment_page");
//	ExtentTestManager.getTest().log(Status.PASS, "Successfully navigated to Fitness Career Opportunities/Employment page: "+t);
//	Log.info("Successfully navigated to Fitness Career Opportunities/Employment page: "+t);
	
//	Employment e= new Employment();
//	e.play_video();
	
	
	}



}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void Main_login(String Value,String Email, String Password) throws InterruptedException, AWTException {
//
//		if (Value.equalsIgnoreCase("Login")) {
//
//			login_popup(Email,Password);
//
//		}
//
//	}
//
//	public void login_popup(String Emails, String Passwords) throws AWTException, InterruptedException {
//
//		click(ProfileButton);
//		Thread.sleep(100);
//		click(LoginOption);
//		Thread.sleep(1000);
//		input(Email, Emails);
//		input(Password, Passwords);
//		ExtentTestManager.getTest().log(Status.PASS, "User Login Credentials entered Successfully");
//		click(LoginButton);
//		Thread.sleep(1000);
//		ExtentTestManager.getTest().log(Status.PASS, "Login Successful");
//
//	}

}
