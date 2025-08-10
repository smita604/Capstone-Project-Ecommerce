package TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

@Test
public class ExtentReport {
	
	 static public void simpleExtentReports() {
		  
			// below class uses to create an HTML file. 
			  ExtentSparkReporter  htmlReport = new ExtentSparkReporter("ECommerce Report.html");
				
				// below class generates report and write the content on it.
				ExtentReports report = new ExtentReports();
				
				report.attachReporter(htmlReport);
				
				
				ExtentTest test;
				//Configuring system info
				report.setSystemInfo("Project Name", "ECommerce");
				report.setSystemInfo("Machine","Windows ASUS");
				report.setSystemInfo("OS","Windows OS");
				report.setSystemInfo("Company","Open Source");
				report.setSystemInfo("User","Smita");
				report.setSystemInfo("Browser","Google Chrome");
				
				//Configuration and look and feel of reports;
				
				htmlReport.config().setDocumentTitle("MyEcommerceReport");
				htmlReport.config().setReportName("ECommerce Automation");
				htmlReport.config().setTheme(Theme.STANDARD);
				htmlReport.config().setTimeStampFormat("dd-MMMM-YYYY");
				
				//creates the report
				test = report.createTest("HomePage");
				test.log(Status.PASS, MarkupHelper.createLabel("HomePage", ExtentColor.GREEN));
				//Generates the report
				report.flush();
		  }

}
