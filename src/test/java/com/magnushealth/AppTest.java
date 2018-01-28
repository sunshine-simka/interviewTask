package com.magnushealth;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppTest {
    @Test
    public void openPageMagnusCC() {
        System.setProperty("webdriver.gecko.driver", "./geckodriver.exe"); //driver for Selenium3
        WebDriver driver = new FirefoxDriver();

//        Test case 1 - User is able to clearly view the MCC document - what is definition of "clear view"?
        driver.navigate().to("https://goo.gl/forms/xwHGsFEOw4m2sBuQ2"); //page opened
        String title = driver.getTitle();
        Assert.assertEquals("The page has an incorrect title", "Magnus Community Connect", title);

        //This form was created inside of Magnus Health.

//        Test case 2 - document contains a valid title and description - title of the page or title on the page? can they be different?
//      Header
        WebElement viewHeader = driver.findElement(By.className("freebirdFormviewerViewHeaderTitle"));
        Assert.assertEquals("The document doesn't contain a valid title ",
                "Magnus Community Connect", viewHeader.getText());
//      Description
        WebElement viewDescription = driver.findElement(By.className("freebirdFormviewerViewHeaderDescription"));
        Assert.assertEquals("With more volunteers and more volunteer opportunities than any other service, Magnus Community Connect is how good people and good causes get connected! Sign up today to give your time to make a difference!", viewDescription.getText());

//        Test case 3 - First Name is required as indicated by the red alert
        WebElement firstName = driver.findElement(By.className("freebirdFormviewerViewItemsItemItemTitle"));
        Assert.assertEquals("There is no required First Name on the page", "First Name *", firstName.getText());
    }


}
