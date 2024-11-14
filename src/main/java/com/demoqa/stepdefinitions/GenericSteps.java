package com.demoqa.stepdefinitions;

import com.demoqa.managers.ConfigReaderManager;
import com.demoqa.managers.DriverManager;
import com.demoqa.managers.ExplicitWaitManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class GenericSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();

    @Given("The defined url + {string} end part is accessed")
    public void theLinkIsAccessed(String endPart) {
        driver.get(ConfigReaderManager.getProperty("url") + endPart);
    }

    @And("The {string} from {string} is clicked")
    public void fromIsClicked(String elementName, String pageName) {
        try {
            Class classInstance = Class.forName("com.demoqa.pageobjects." + pageName);
            Field element = classInstance.getDeclaredField(elementName);
            element.setAccessible(true);
            WebElement webElement = (WebElement) element.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
            ExplicitWaitManager.waitTillTheElementIsVisible(webElement);
            ExplicitWaitManager.waitTillTheElementIsClickable(webElement);
            webElement.click();
        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
