package com.magnushealth;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

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
        WebElement firstNameDiv = driver.findElement(By.xpath("//div[text()[contains(.,'First Name')]]"));
        Assert.assertEquals("There is no required First Name on the page", "First Name *", firstNameDiv.getText());

//        Test case 4 - After SUBMIT form: the first name field has been highlighted in red and displays the message
//        enterLastName
        WebElement enterLastName = driver.findElement(By.name("entry.2001128852"));
        enterLastName.sendKeys("Simatova");

//       enter Phone Number
        WebElement enterPhoneNumber = driver.findElement(By.name("entry.1027052036"));
        enterPhoneNumber.sendKeys("610-844-4963");

//       enter Email
        WebElement enterEmail = driver.findElement(By.name("entry.2001249042"));
        enterEmail.sendKeys("simatova.irina@gmail.com");

//       enter Volunteer Date
        WebElement enterDate = driver.findElement(By.xpath("//input[ancestor::div[@data-item-id='610737828']]"));
        enterDate.sendKeys("03" + Keys.TAB + "20" + Keys.TAB + "2003");

//        push SUBMIT button
        WebElement submit = driver.findElement(By.className("freebirdFormviewerViewNavigationSubmitButton"));
        submit.click();

//        check error message and color
        WebElement errorMessage = driver.findElement(By.xpath("//div[ancestor::div[@data-item-id='431395505'] and @class = 'freebirdFormviewerViewItemsItemErrorMessage']"));
        Assert.assertEquals("Wrong error message", "This is a required question", errorMessage.getText());
        Assert.assertEquals("Wrong error color", "rgb(219, 68, 55)", errorMessage.getCssValue("Color"));
//        Test case 5 - success message that states 'Your response has been recorded'
//        enterFirstName and submit
        WebElement enterFirstName = driver.findElement(By.name("entry.601248361"));
        enterFirstName.sendKeys("Irina1");

        submit.sendKeys(Keys.ENTER);
        new Actions(driver).moveToElement(submit).click().perform();
        submit.click();
        driver.switchTo().defaultContent();

//        check success message
        WebElement successMessage = driver.findElement(By.className("freebirdFormviewerViewResponseConfirmationMessage"));
        Assert.assertEquals("Wrong success message", "Your response has been recorded.", successMessage.getText());

    }
}
