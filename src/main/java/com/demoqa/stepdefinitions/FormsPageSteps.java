package com.demoqa.stepdefinitions;

import com.demoqa.managers.DriverManager;
import com.demoqa.managers.FakeDataManager;
import com.demoqa.pageobjects.FormsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;

public class FormsPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    FormsPage formsPage = new FormsPage(driver);

    private static final Logger logger = LogManager.getLogger(FormsPageSteps.class);

    @When("Forms Page is populated with the following data:")
    public void formsPageIsPopulatedWithTheFollowingData(Map<String, String> userDetailsMap) {
        String firstName = userDetailsMap.get("firstName");
        String lastName = userDetailsMap.get("lastName");
        String email = userDetailsMap.get("email");
        String phoneNumber = userDetailsMap.get("phoneNumber");

        if (firstName != null && firstName.equals("RANDOM")) {
            firstName = FakeDataManager.generateRandomFirstname();
        }

        if (lastName != null && lastName.equals("RANDOM")) {
            lastName = FakeDataManager.generateRandomLastname();
        }

        if (email != null && email.equals("RANDOM")) {
            email = FakeDataManager.generateRandomEmail();
        }

        if (phoneNumber != null && phoneNumber.equals("RANDOM")) {
            phoneNumber = FakeDataManager.generateRandomPhoneNumber();
        }

        logger.log(Level.INFO, "First name: " + firstName);
        logger.log(Level.INFO, "Last name: " + lastName);
        logger.log(Level.INFO, "Email: " + email);
        logger.log(Level.INFO, "Phone number: " + phoneNumber);

        formsPage.fillInTheForm(firstName, lastName, email, phoneNumber);

    }

    @Then("The confirmation message is displayed")
    public void theConfirmationMessageIsDisplayed() {
        Assertions.assertTrue(driver.findElement(By.id("example-modal-sizes-title-lg")).isDisplayed());
    }

}
