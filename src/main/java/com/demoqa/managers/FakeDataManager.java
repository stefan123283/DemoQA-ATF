package com.demoqa.managers;

import com.github.javafaker.Faker;

public class FakeDataManager {
    private static Faker faker = new Faker();

    public static String generateRandomFirstname() {
        return faker.name().firstName();
    }

    public static String generateRandomLastname() {
        return faker.name().lastName();
    }

    public static String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateRandomPhoneNumber() {
        return faker.numerify("##########");
    }

}
