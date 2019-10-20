package com.cyber.step_defenitions;

import com.cyber.pages.Login_Page;
import com.cyber.utilities.ConfigurationReader;
import com.cyber.utilities.Driver;
import com.cyber.utilities.ExcelUtils;
import cucumber.api.java.en.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Assert;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public class Login_step_defenitions {
    String path = "./src/test/resources/excel_files/ExcelCredentials.xlsx";
    ExcelUtils excelUtils = new ExcelUtils(path, "credentials");
    List<Map<String, String>> userData = excelUtils.getDataList();

    Login_Page loginPage = new Login_Page();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.out.println("I am login page");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("I login as a {string}")
    public void i_login_as_a(String user_name) {

        for (Map<String, String> each : userData) {
            if (each.get("title").trim().equals(user_name)) {
                loginPage.logIn(each.get("user_name").trim(), each.get("password").trim());

            }
        }

    }


    @Then("I should be able to see correct {string}")
    public void i_should_be_able_to_see_correct(String title) {

        System.out.println("seeing: " + title);
        String actualFullName = loginPage.userFullNameLocator.getText();
        for (Map<String, String> eachone : userData) {
            if (eachone.get("title").equals(title)) {
                String expectedFullName = (eachone.get("first_name") + " " + eachone.get("last_name")).trim();
                Assert.assertEquals(actualFullName, expectedFullName);
                System.out.println("expected full name " + expectedFullName + "/" + "actual full name " + actualFullName);
            }

        }


    }


}