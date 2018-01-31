package com.magnushealth.pageObgects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormResponsePage {
    @FindBy(className = "freebirdFormviewerViewResponseConfirmationMessage")
    private WebElement successMessageElement;
    private WebDriver driver;

    public FormResponsePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSuccessMessage() {
        return successMessageElement.getText();
    }
}
