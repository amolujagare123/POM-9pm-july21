package Util.ForListners;


import Util.OpenUrl;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static Util.ForListners.Init.initExtentReports;
import static Util.ForListners.Init.takescreenshot;


public class MyListnersExtentReport extends OpenUrl implements ITestListener {

    static ExtentReports extent;
    ExtentTest test;

    public void onTestStart(ITestResult result) {

        System.out.println("onTestStart");
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess");

        test.pass(result.getMethod().getMethodName()+":this test is passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
        test.info(result.getMethod().getMethodName()+":this test is failed");
        test.fail(result.getThrowable());
        try {

            test.addScreenCaptureFromPath("./screenshots/"+takescreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped");
        test.skip(result.getMethod().getMethodName()+":this test is skipped");
    }

    public void onStart(ITestContext context) {

        if(extent==null)
            extent = initExtentReports();

    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
