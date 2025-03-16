package harshakr.HyperTestCore;

import com.github.javafaker.Faker;

public class FakeDataUtil {

    private static final Faker faker = new Faker();

    // Generate a random full name
    public static String getFullName() {
        return faker.name().fullName();
    }

    // Generate a random first name
    public static String getFirstName() {
        return faker.name().firstName();
    }

    // Generate a random last name
    public static String getLastName() {
        return faker.name().lastName();
    }

    // Generate a random email address
    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    // Generate a random phone number
    public static String getPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    // Generate a random address
    public static String getAddress() {
        return faker.address().fullAddress();
    }

    // Generate a random company name
    public static String getCompanyName() {
        return faker.company().name();
    }

    // Generate a random job title
    public static String getJobTitle() {
        return faker.job().title();
    }

    // Generate a random city
    public static String getCity() {
        return faker.address().city();
    }

    // Generate a random country
    public static String getCountry() {
        return faker.address().country();
    }

    // Generate a random credit card number
    public static String getCreditCardNumber() {
        return faker.finance().creditCard();
    }

    // Generate a random lorem ipsum sentence
    public static String getLoremSentence() {
        return faker.lorem().sentence();
    }
}
