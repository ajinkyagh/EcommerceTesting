package apiDemos;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

//Just add listeners tag in xml file
// <listener class-name="apiDemos.Listeners"/>

//ITestListener interface which implements Testng listeners
public class Listeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub

        //System.out.println("I successfully executed Listeners Pass code");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        String s=result.getName();
        try {
            Basic.getScreenshot(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("I failed executed Listeners Pass code" +result.getName());
        //System.out.println("I failed executed Listeners Pass code" +result.getName());  //returns the method name that has failed

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
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }

}
