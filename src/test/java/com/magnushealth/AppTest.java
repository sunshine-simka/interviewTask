package com.magnushealth;

import com.magnushealth.pageObgects.FormResponsePage;
import com.magnushealth.pageObgects.ViewFormPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AppTest {
    @Test
    public void usingPageObjects() {
        System.setProperty("webdriver.gecko.driver", "./geckodriver.exe"); //driver for Selenium3
        final FirefoxOptions options = new FirefoxOptions();
        options.addPreference("security.sandbox.content.level", 5); //fix FireFox to run from Jenkins
        WebDriver driver = new FirefoxDriver(options);
        ViewFormPage formPage = new ViewFormPage(driver);
        FormResponsePage responsePage = new FormResponsePage(driver);

//        Test case 1 - User is able to clearly view the MCC document - what is definition of "clear view"?
        formPage.openPage();
        Assert.assertEquals("The page has an incorrect title",
                "Magnus Community Connect", formPage.getTitle());
        Assert.assertEquals("The page has an incorrect footer",
                "This form was created inside of Magnus Health. Report Abuse - Terms of Service - Additional Terms",
                formPage.getFooter());

//        Test case 2 - document contains a valid title and description
        Assert.assertEquals("The document doesn't contain a valid Header",
                "Magnus Community Connect", formPage.getHeader());
        Assert.assertEquals("The document doesn't contain a valid Description",
                "With more volunteers and more volunteer opportunities than any other service, Magnus Community " +
                        "Connect is how good people and good causes get connected! Sign up today to give your time to make a difference!",
                formPage.getDescription());

//        Test case 3 - First Name is required as indicated by the red alert
        Assert.assertEquals("There is no required First Name on the page",
                "First Name *", formPage.getFirstName());

//        Test case 4 - After SUBMIT form: the first name field has been highlighted in red and displays the message
        formPage.enterInfoInForm("", "Old MacDonald", "610-111-1111", "eieio@gmail.com",
                "01" + Keys.TAB + "02" + Keys.TAB + "2018");
        formPage.submitFailedForm();
        Assert.assertEquals("Wrong error message",
                "This is a required question", formPage.getErrorMessage());
        Assert.assertEquals("Wrong error color", "rgb(219, 68, 55)", formPage.getErrorColor());

//        Test case 5 - success message
        formPage.enterInfoInForm("SamIam", "", "", "", "");
        formPage.submitForm();
        Assert.assertEquals("There is a wrong message",
                "Your response has been recorded.", responsePage.getSuccessMessage());
    }
}
