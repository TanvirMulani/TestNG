package com.qc.utils;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestNGReporter {

	static ExtentReports extent;

	public static ExtentReports getReportObject() {
		String path = "test-output/TestNGReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Test Automation Report");
		reporter.config().setDocumentTitle("Queue Codes Test Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "Queue Codes");
		extent.setSystemInfo("User Name", "Tanvir Mulani");
		return extent;
	}
}
