package com.demoqa.pageobjects;

import com.demoqa.managers.ScrollManager;
import com.demoqa.managers.ExplicitWaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends Page {
    public FormsPage(WebDriver driver) {
        super(driver);
    }

    ScrollManager scrollManager = new ScrollManager(driver);

    @FindBy(id = "firstName")
    private WebElement firstNameInput;
    @FindBy(id = "lastName")
    private WebElement lastNameInput;
    @FindBy(id = "userEmail")
    private WebElement emailInput;
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
    private WebElement maleCheckbox;
    @FindBy(id = "userNumber")
    private WebElement mobileInput;
    @FindBy(id = "submit")
    private WebElement submitButton;

    public void fillInTheForm(String firstName, String lastName, String email, String phoneNumber) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        scrollManager.scrollToElement(maleCheckbox);
        ExplicitWaitManager.waitTillTheElementIsClickable(maleCheckbox);
        maleCheckbox.click();
        mobileInput.sendKeys(phoneNumber);
        scrollManager.scrollToElement(submitButton);
        ExplicitWaitManager.waitTillTheElementIsClickable(submitButton);
        submitButton.click();
    }

}
