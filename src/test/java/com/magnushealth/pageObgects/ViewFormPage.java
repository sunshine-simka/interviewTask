package com.magnushealth.pageObgects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewFormPage {
    private WebDriver driver;
    @FindBy(className = "freebirdFormviewerViewHeaderTitle")
    private WebElement headerElement;
    @FindBy(className = "freebirdFormviewerViewHeaderDescription")
    private WebElement descriptionElement;
    @FindBy(className = "freebirdFormviewerViewFooterDisclaimer")
    private WebElement footerElement;
    @FindBy(xpath = "//div[text()[contains(.,'First Name')]]")
    private WebElement firstNameDiv;
    @FindBy(name = "entry.601248361")
    private WebElement firstNameElement;
    @FindBy(name = "entry.2001128852")
    private WebElement lastNameElement;
    @FindBy(name = "entry.1027052036")
    private WebElement phoneNumberElement;
    @FindBy(name = "entry.2001249042")
    private WebElement emailElement;
    @FindBy(xpath = "//input[ancestor::div[@data-item-id='610737828']]")
    private WebElement volunteerDateElement;
    @FindBy(className = "freebirdFormviewerViewNavigationSubmitButton")
    private WebElement submitButtonElement;
    @FindBy(xpath = "//div[ancestor::div[@data-item-id='431395505'] and @class = 'freebirdFormviewerViewItemsItemErrorMessage']")
    private WebElement errorMessageElement;

    public ViewFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.navigate().to("https://goo.gl/forms/xwHGsFEOw4m2sBuQ2"); //page opened
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getHeader() {
        return headerElement.getText();
    }

    public String getDescription() {
        return descriptionElement.getText();
    }

    public String getFooter() {
        return footerElement.getText();
    }

    public String getFirstName() {
        return firstNameDiv.getText();
    }

    public void enterInfoInForm(String firstName, String lastName, String phoneNumber, String email,
                                String volunteerDate) {
        firstNameElement.sendKeys(firstName);
        lastNameElement.sendKeys(lastName);
        phoneNumberElement.sendKeys(phoneNumber);
        emailElement.sendKeys(email);
        volunteerDateElement.sendKeys(volunteerDate);
    }

    public void submitFailedForm() {
        submitButtonElement.click();
    }

    public void submitForm() {
        submitButtonElement.sendKeys(Keys.ENTER);
        new Actions(driver).moveToElement(submitButtonElement).click().perform();
        submitButtonElement.click();
        driver.switchTo().defaultContent();
    }

    public String getErrorMessage() {
        return errorMessageElement.getText();
    }

    public String getErrorColor() {
        return errorMessageElement.getCssValue("Color");
    }
}
