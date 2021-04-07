package Utilities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReport {
	public static ExtentHtmlReporter htmlReporter;
	private static ExtentReports reports;
	private static String foldername;

	public static void createExtentReports() {
		htmlReporter = new ExtentHtmlReporter(getDirectory() + getFileName());
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Reporting");
		htmlReporter.config().setReportName("Reporting V1");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
	}

	public static synchronized ExtentTest createTest(String testName) {
		return reports.createTest(testName);
	}

	public static void closeReport() {
		if (reports != null) {
			reports.flush();
		}
	}

	public static void foldername() {
		foldername=System.getProperty("user.dir");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		foldername = foldername + "\\Report\\"
				+ format.format(date).toString().replace(":", "_").replace(" ", "").replace("-", "_");
		try {
			File file = new File(foldername );
			file.mkdir();
			System.out.println("Folder:"+foldername);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public static String getFileName() {
		String reportname = "\\Report.html";
		return reportname;
	}
	
	public static String getDirectory() {
		return foldername;
	}

}
