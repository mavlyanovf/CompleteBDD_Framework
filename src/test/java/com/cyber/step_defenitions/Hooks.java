package com.cyber.step_defenitions;

import com.cyber.utilities.Driver;
import com.cyber.utilities.ExcelUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;

import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("Setting up from Hooks class");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();

    }



    @After
    public void tearDown(Scenario scenario){
        System.out.println("I am reporting the results");
//       To take screenshot when current scenario fails
//        scenario.isFailed() --> tells if the scenario failed or not
        if (scenario.isFailed()){
//            this line is for taking screenshot
            final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//            this line is adding the screenshot to the report
            scenario.embed(screenshot, "image/png");
        }
        System.out.println("Closing driver");
        Driver.closeDriver();

    }
}
