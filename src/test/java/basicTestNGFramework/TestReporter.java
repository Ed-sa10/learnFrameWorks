package basicTestNGFramework;

import java.util.UUID;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestReporter{
	public ExtentTest test;
	public static ExtentReports extent;
	public String testCaseName, testDescription, category, authors;
	public static UUID uuid;

	public static void main(String[] args) {
				TestReporter tr = new TestReporter();
				tr.startResult();
				tr.startTestCase("SomeTestA1", "Lets create the Test 01");
				tr.reportStep("AAAAA", "PASS");
				tr.endTestcase();
				tr.startTestCase("SomeOtherTestB1", "Lets create the Test 02");
				tr.reportStep("BBBBB", "FAIL");
				tr.endTestcase();
				tr.startTestCase("SomeOtherTestC1", "Lets create the Test 03");
				tr.reportStep("CCCCC", "INFO");
				tr.endTestcase();
				tr.endResult();
				System.out.println("Done");
				
	}
	public void reportStep(String desc, String status) {

		
		uuid = UUID.randomUUID();
		
		// Write if it is successful or failure or information
		if(status.toUpperCase().equals("PASS")){
			test.log(LogStatus.PASS, desc+test.
					addScreenCapture("./../reports/images/"+uuid.toString()+".jpg"));
		}else if(status.toUpperCase().equals("FAIL")){
			test.log(LogStatus.FAIL, desc+test.addScreenCapture("./../reports/images/"+uuid.toString()+".jpg"));
			//throw new RuntimeException("FAILED");
		}else if(status.toUpperCase().equals("INFO")){
			test.log(LogStatus.INFO, desc);
		}
		
	}
	public void reportStepNoSnap( String desc,String status) {

		
		
		// Write if it is successful or failure or information
		if(status.toUpperCase().equals("PASS")){
			test.log(LogStatus.PASS,desc);
		}else if(status.toUpperCase().equals("FAIL")){
			test.log(LogStatus.FAIL, desc);
			//throw new RuntimeException("FAILED");
		}else if(status.toUpperCase().equals("INFO")){
			test.log(LogStatus.INFO, desc);
		}
	}

	public ExtentReports startResult(){
		//extent = new ExtentReports("./reports/result.html", false);
		//extent.loadConfig(new File("./src/test/resources/extent-config.xml"));
		
		UUID uuid = UUID.randomUUID();
		String path = "./reports/result" + uuid.toString() + ".html";
		System.out.println("Saving report as : " + path);
		extent = new ExtentReports(path, false);
		return extent;
	}

	public ExtentTest startTestCase(String testCaseName, String testDescription){
		test = extent.startTest(testCaseName, testDescription);
		return test;
	}

	public void endResult(){		
		extent.flush();
	}

	public void endTestcase(){
		extent.endTest(test);
	}

}
