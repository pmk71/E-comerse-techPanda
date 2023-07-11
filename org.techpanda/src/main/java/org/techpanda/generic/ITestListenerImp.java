package org.techpanda.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.core.sym.Name;

public class ITestListenerImp extends  BaseClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getName();
		test=report.createTest(name);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String name = result.getName();
		test.log(Status.PASS, name+"----->Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		TakesScreenshot ts= 	(TakesScreenshot) getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File desc= new File("./screenshot/"+name+"--"+new SUtils().getDateStamp()+".png");
		String path = desc.getAbsolutePath();
		try {
			FileUtils.copyDirectory(src, desc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.addScreenCaptureFromPath(path);
		test.log(Status.FAIL, name+"----->Fail");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {


		ExtentSparkReporter htmlreport= new ExtentSparkReporter("./ExtentReports/report"+new SUtils().getDateStamp()+".html");
		htmlreport.config().setDocumentTitle("TechPands");
		htmlreport.config().setTheme(Theme.STANDARD);

		report= new ExtentReports();
		report.attachReporter(htmlreport);
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();


	}

}
