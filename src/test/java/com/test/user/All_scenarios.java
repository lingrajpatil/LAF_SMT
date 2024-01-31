	package com.test.user;
	
	import java.io.File;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.Map;
	import org.testng.ITestContext;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeSuite;
	import org.apache.commons.lang3.ObjectUtils.Null;
	import org.apache.poi.hssf.record.PageBreakRecord.Break;
	import org.testng.*;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import com.BasePackage.Base_Class;
	import com.Utility.Log;
	import com.aventstack.extentreports.MediaEntityBuilder;
	import com.aventstack.extentreports.Status;
	import com.extentReports.ExtentManager;
	import com.extentReports.ExtentTestManager;
	import com.google.common.base.Throwables;
	import com.listeners.TestListener;
	
	public class All_scenarios extends Base_Class  {
	
		Base_Class Base_Class;
		
		Log log;
		TestListener TestListener;
		com.Utility.ScreenShot screenShot;
		
		com.pages.SMT_LoginPage SMT_LoginPage;
		
		
		@BeforeSuite
		public void reference() {
			Base_Class = new Base_Class();
			log = new Log();
			TestListener = new TestListener();
			screenShot = new com.Utility.ScreenShot(null);
		
			SMT_LoginPage = new com.pages.SMT_LoginPage();

		}
		
		@Test
		public void CheckGoogleURL(ITestContext context) throws Exception
		{
//			Base_Class.setup();
//			context.setAttribute("fileName", "CheckGoogle_URL");
//			SMT_LoginPage.TC_04_Validate_GoogleURL("CheckGoogle_URL","Test");
//			driver.quit();
 
			
//					*/
		}
		@Test
		public void CheckGoogleSearchBox(ITestContext context) throws Exception
		{
//			Base_Class.setup();
//			context.setAttribute("fileName", "Check_search_textbox");
//			SMT_LoginPage.TC_05_Validate_SearchTextbox("Check_search_textbox","Test");
//			driver.quit();
		}
		@Test
		public void CheckGoogleSearchButton(ITestContext context) throws Exception
		{
//			Base_Class.setup();
//			context.setAttribute("fileName", "Click_btn_GoogleSeach");
//			SMT_LoginPage.TC_06_Validate_Click_btn_GoogleSearch("Click_btn_GoogleSeach","Test");
//			driver.quit();
		}
		
		@Test(dataProvider = "TestData")
		public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws Throwable {
	
			try {
	
				if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
					String fileName;
					ExtentTestManager.startTest(testdata.get("TestScenario").toString());
					ExtentTestManager.getTest().log(Status.PASS, "*** Test Suite " + testdata.get("TestScenario").toString() + " running Starting ***");
					Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
					ExtentTestManager.getTest().log(Status.PASS, "*** Running test method " + testdata.get("TestScenario").toString() + "...");
				
					String Change_brand_name=testdata.get("Change_brand_name").toString();
					if(testdata.get("TextMessage").toString().trim().equalsIgnoreCase("Change_Brand".trim())) {
						
						Base_Class.setup_Change_brand();
						if(!Change_brand_name.isEmpty() && !Change_brand_name.isEmpty()) Base_Class.Change_Brand(Change_brand_name);
						
					else {
						
						throw new Exception("please provide brand name to change the brand");
					
						}
						
						driver.quit();
						
					}
					
					else {
						Base_Class.setup();
					}
	
					ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into Application URL ");
	
	
					String Dropdown_values=testdata.get("Dropdown_values").toString();
	
					String Country =testdata.get("Country").toString();
					String Ratesoramenities =testdata.get("Rates/amenities").toString();
					String Club_name =testdata.get("Club_name").toString();
					
					String Add_amenities =testdata.get("Add_amenities").toString();
					String Included_amenities =testdata.get("Included_amenities").toString();
				
					String Amount_details =testdata.get("Amount_details").toString();
					String rates_details =testdata.get("Rates_details").toString();
					String plan_rates =testdata.get("Plan_rates").toString();
					
					
					
					
					String Text_input =testdata.get("Text_input").toString();
		
					
					String Number_of_Persons1 =testdata.get("Number_of_Persons1").toString();
					String Initiation_Fee =testdata.get("Initiation_Fee").toString();
					String Billing_Frequency =testdata.get("Billing_Frequency").toString();				
					String Initial_Term =testdata.get("Initial_Term").toString();
					String Prepayment =testdata.get("Prepayment").toString();
					String First_Month_Dues =testdata.get("First_Month_Dues").toString();
					String Last_Month_Dues =testdata.get("Last_Month_Dues").toString();
					String Total_initial_Payment =testdata.get("Total_initial_Payment").toString();	
					String Annual_Fee_Per_Person =testdata.get("Annual_Fee_Per_Person").toString();
					
					String Everemployed_rdobtn =testdata.get("Everemployed_rdobtn").toString();
					String Date_to_begin =testdata.get("Date_to_begin").toString();
					String Languages =testdata.get("Languages").toString();
					String Work_time =testdata.get("Work_time").toString();
					String Url =testdata.get("Url").toString();
					String additional_input =testdata.get("additional_input").toString();
					String input_data =testdata.get("input_data").toString();
					String input_data1 =testdata.get("input_data1").toString();
					String input_data2 =testdata.get("input_data2").toString();
					String input_data3 =testdata.get("input_data3").toString();
					String input_data4 =testdata.get("input_data4").toString();
					String input_data5 =testdata.get("input_data5").toString();
					String input_data6 =testdata.get("input_data6").toString();
					String IP_Address =testdata.get("IP_Address").toString();
					
					String File_name =testdata.get("File_name").toString();
					
					String Job_short_des =testdata.get("Job_short_des").toString();
					String Job_long_des =testdata.get("Job_long_des").toString();
					String F_Name =testdata.get("F_Name").toString();
					String L_Name =testdata.get("L_Name").toString();
					String Full_name =testdata.get("Full_name").toString();
					String Phone =testdata.get("Member_Phone").toString();
					String Email =testdata.get("Email").toString();
					String Address =testdata.get("Member_address").toString();
	//				job_short_des
					String City =testdata.get("Member_City").toString();
					
					String E_EducationLeve_Dropdown = testdata.get("E_EducationLeve_Dropdown").toString();
	
					String Aerobics_Instructor_Exp_DD = testdata.get("Aerobics_Instructor_Exp_DD").toString();
					String Time_period_DD = testdata.get("Time_period_DD").toString();
					String Club_Employer_DD = testdata.get("Club_Employer_DD").toString();
					String Class_per_week = testdata.get("Class_per_week").toString();
					
					String EmploymentHowResigned_dd = testdata.get("EmploymentHowResigned_dd").toString();
					String PriorEmploymentWhyResigned_ip = testdata.get("PriorEmploymentWhyResigned_ip").toString();
					String EmploymentWhyLeaveCurrent_ip = testdata.get("EmploymentWhyLeaveCurrent_ip").toString();
					String EmploymentWhyReapply_ip = testdata.get("EmploymentWhyReapply_ip").toString();
					String EmploymentWhatLike_ip = testdata.get("EmploymentWhatLike_ip").toString();
					String EmploymentWhatDislike_ip = testdata.get("EmploymentWhatDislike_ip").toString();
					
					String EmploymentSuccess_ip = testdata.get("EmploymentSuccess_ip").toString();
					String EmploymentWhyResignInFuture_ip = testdata.get("EmploymentWhyResignInFuture_ip").toString();
					String Gender_dd = testdata.get("Gender_dd").toString();
					String RaceEthnicity_dd = testdata.get("RaceEthnicity_dd").toString();
	//				String EmploymentHowResigned_dd = testdata.get("EmploymentHowResigned_dd").toString();
	//				String EmploymentHowResigned_dd = testdata.get("EmploymentHowResigned_dd").toString();
	//				String EmploymentHowResigned_dd = testdata.get("EmploymentHowResigned_dd").toString();
	//				
					String Personal_Training_ExperienceDPValues = testdata.get("Personal_Training_ExperienceDPValues").toString();
					String Certification_IssuedByDPValues = testdata.get("Certification_IssuedByDPValues").toString();
					String Hold_cert_GT_AC_ratio_button = testdata.get("Hold_cert_GT_AC_ratio_button").toString();
					String Certified_In_DD = testdata.get("Certified_In_DD").toString();
					String Certificate_No = testdata.get("Certificate_No").toString();
					String Emp_gap = testdata.get("Emp_gap").toString();
					String Employer_name = testdata.get("Employer_name").toString();
					String Supervisor_name = testdata.get("Supervisor_name").toString();
					String From_date = testdata.get("From_date").toString();
					String To_date = testdata.get("To_date").toString();
					String Job_title = testdata.get("Job_title").toString();
					String Leaving_Reason = testdata.get("Leaving_Reason").toString();
					String Emp_details = testdata.get("Emp_details").toString();
					String Can_contact_radio_button = testdata.get("Can_contact_radio_button").toString();
					
					
					String Club_phone =testdata.get("Club_phone").toString();
					String Club_zip =testdata.get("Club_zip").toString();
					String Club_Address =testdata.get("Club_Address").toString();
					String Club_city =testdata.get("Club_city").toString();
	//				
					String State =testdata.get("State").toString();
					String Zipcode =testdata.get("Member_Zipcode").toString();
					String Radius_travel_to_work =testdata.get("Radius_travel_to_work").toString();
					String How_hear_abt_us =testdata.get("How_hear_abt_us").toString();
					String Radiobtn18YearsOld =testdata.get("Radiobtn18YearsOld").toString();
					String Payment_type =testdata.get("Payment_type").toString();
					String Card_number  =testdata.get("Card_number").toString();
					
					String Ex_month =testdata.get("Ex_month").toString();
					String Ex_year  =testdata.get("Ex_year").toString();
					
					String Routing_number  =testdata.get("Routing_number").toString();
					String Account_number =testdata.get("Account_number").toString();
					String Card_name =testdata.get("Card_name").toString();
					String Checkbox_class_formats =testdata.get("Checkbox_class_formats").toString();

					String No_Prev_emp_chk_box =testdata.get("No_Prev_emp_chk_box").toString();
				
							
					switch (testdata.get("TextMessage").toString()) {
					
					case "SMTtitle_Text":
	
						context.setAttribute("fileName", "SMTtitle_Text");
						SMT_LoginPage.TC_01_Validate_SMTtitle_Text(testdata.get("TextMessage").toString(),Text_input);
						context.setAttribute("fileName", "SMTtitle_Text");
						driver.quit();break;
						
					case "Text_ConfigChek_CCpop":
						
						context.setAttribute("fileName", "Text_ConfigChek_CCpop");
						SMT_LoginPage.TC_02_Validate_Text_ConfigChek_CCpop(testdata.get("TextMessage").toString(),Text_input);
						context.setAttribute("fileName", "Text_ConfigChek_CCpop");
						driver.quit();break;
		
					case "Click_btn_Contine_CCpop":
						
						context.setAttribute("fileName", "Click_btn_Contine_CCpop");
						SMT_LoginPage.TC_03_Validate_Click_btn_Contine_CCpop(testdata.get("TextMessage").toString(),Text_input);
						context.setAttribute("fileName", "Click_btn_Contine_CCpop");
						driver.quit();break;
			
						
					case "CheckGoogle_URL":
						
						context.setAttribute("fileName", "CheckGoogle_URL");
						SMT_LoginPage.TC_04_Validate_GoogleURL(testdata.get("TextMessage").toString(),Text_input);
						context.setAttribute("fileName", "CheckGoogle_URL");
						driver.quit();break;
			
					case "Check_search_textbox":
						
						context.setAttribute("fileName", "Check_search_textbox");
						SMT_LoginPage.TC_05_Validate_SearchTextbox(testdata.get("TextMessage").toString(),Text_input);
						context.setAttribute("fileName", "Check_search_textbox");
						driver.quit();break;
					
						
					case "Click_btn_GoogleSeach":
						
						context.setAttribute("fileName", "Click_btn_GoogleSeach");
						SMT_LoginPage.TC_06_Validate_Click_btn_GoogleSearch(testdata.get("TextMessage").toString(),Text_input);
						context.setAttribute("fileName", "Click_btn_GoogleSeach");
						driver.quit();break;
	//					*/
						
					case "CheckLAF_Title":
						
						context.setAttribute("fileName", "CheckLAF_Title");
						SMT_LoginPage.TC_07_Validate_LAF_Title(testdata.get("TextMessage").toString(),Text_input);
						context.setAttribute("fileName", "CheckLAF_Title");
						driver.quit();break;
			
					case "Check_LAF_JoinNowHeaderButton":
						
						context.setAttribute("fileName", "Check_LAF_JoinNowHeaderButton");
						SMT_LoginPage.TC_08_Validate_LAF_JoinNowButton(testdata.get("TextMessage").toString(),Text_input);
						context.setAttribute("fileName", "Check_LAF_JoinNowHeaderButton");
						driver.quit();break;
					
						
					case "Click_JoinNowHeaderButton":
						
						context.setAttribute("fileName", "Click_JoinNowHeaderButton");
						SMT_LoginPage.TC_09_Validate_JoinNowClick(testdata.get("TextMessage").toString(),Text_input);
						context.setAttribute("fileName", "Click_JoinNowHeaderButton");
						driver.quit();break;
	//					*/
	
						
						
					default:
						driver.quit();
						break;
	
					}
	
					// EndTest
	//				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
					ExtentTestManager.getTest().log(Status.PASS, "*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
					ExtentTestManager.getTest().log(Status.PASS, "Browser is closed");
					ExtentTestManager.endTest();
					ExtentManager.getInstance().flush();
					Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
					Log.info("Browser is closed");
	
	
				}
	
			} 
			catch (Exception e)
			{
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.FAIL, "*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
				Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
				String stackTrace = Throwables.getStackTraceAsString(e);
				Log.error( stackTrace);
			
				
				String fileName = (String) context.getAttribute("fileName");
	
				try {
					File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
							testdata.get("TestScenario").toString());
					ExtentTestManager.getTest().fail(e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
					ExtentTestManager.getTest().log(Status.FAIL, e);
					} 
				catch (Exception e1) {
					System.out.println("File not found " + e1);
									}
				ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	
	//			 Logout
				context.setAttribute("fileName", "Logout");
				if (com.test.user.All_scenarios.driver!=null)driver.quit();
				ExtentTestManager.getTest().log(Status.PASS, "Browser is closed");
				Log.info("Browser is closed");
	
				// EndTest
				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
				throw new Exception(stackTrace);
			} 
			catch (AssertionError e) 
			{
				Thread.sleep(1000);
	//			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
				ExtentTestManager.getTest().log(Status.FAIL, "*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
				Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
				String stackTrace = Throwables.getStackTraceAsString(e);
				Log.error( stackTrace);
				
				String fileName = (String) context.getAttribute("fileName");
	
				try {
					File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
							testdata.get("TestScenario").toString());
					ExtentTestManager.getTest().fail(e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
					ExtentTestManager.getTest().log(Status.FAIL, e);
					} 
				catch (Exception e1)
				{
					System.out.println("File not found " + e1);
				}
				ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	
				// Logout
				context.setAttribute("fileName", "Logout");
				driver.quit();
				ExtentTestManager.getTest().log(Status.PASS, "Browser is closed");
				Log.info("Browser is closed");
	
				// EndTest
				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
				
				throw new Exception(stackTrace);
				
			}
		}
	
	
		
		@DataProvider(name = "TestData")
		public static Object[][] gettestdate() throws IOException {
	
			Object[][] objectarry = null;
			java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata("LAF");
	
			java.util.List<Map<String, String>> completedata1 = new ArrayList<Map<String,String>>();
			int j=0;
	
			for (int i = 0; i < completedata.size(); i++) {
				if(completedata.get(i).get("Run").toString().equalsIgnoreCase("Yes")) 
				{
				completedata1.add(j, completedata.get(i));
				j++;
				}
			}
			
			objectarry = new Object[completedata1.size()][1];
			
			for (int i = 0; i < completedata1.size(); i++) {
				objectarry[i][0] = completedata1.get(i);
			}
			return objectarry;
	
		}
	
		public void Takescreenshot(String fileName, String scenario) {
			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						scenario);
				ExtentTestManager.getTest().pass("File upload screenshot",
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
				
				} 
			catch (Exception e1) {
				System.out.println("File not found " + e1);
								}
		}
		
	}
