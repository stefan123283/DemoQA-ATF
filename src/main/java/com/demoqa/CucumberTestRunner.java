package com.demoqa;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/com/demoqa/features",
        glue = "com.demoqa.stepdefinitions",
        tags = "@Regression1",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html",})

public class CucumberTestRunner {
}
