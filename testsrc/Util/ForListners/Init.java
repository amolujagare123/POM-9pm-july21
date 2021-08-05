package Util.ForListners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Init {

    public static  ExtentReports initExtentReports()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Report\\report.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        reporter.config().setDocumentTitle("My Report Document");
        reporter.config().setReportName("Regression report");

        extent.setSystemInfo("Project name","stock management");
        extent.setSystemInfo("Developers name","Hemangi");
        extent.setSystemInfo("Testers Name","Avinash");
        extent.setSystemInfo("DeadLine","7 aug 2021");
        extent.setSystemInfo("Testing tool","Selenium");

        return extent;
    }

    public static String takescreenshot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;

        File scrFile = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss")
                .format(new Date());

        String fileName = "IMG"+timeStamp+".png";

        FileUtils.copyFile(scrFile,new File("Report\\screenshots\\"+fileName));

        return fileName;

    }
}
