package com.demoqa.stepdefinitions;

import com.demoqa.managers.DriverManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private static int counter = 1;
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @Before
    public void beforeEach() {
        logger.log(Level.INFO, "The execution of test " + counter++ + " has started");
    }

//    @After
//    public void afterEach() {
//        DriverManager.getInstance().quitTheDriver();
//    }

}