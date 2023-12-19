package stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.apache.commons.lang3.RandomStringUtils;
import pageObjects.AddNewCustomerPage;
import pageObjects.LoginPage;

public class BaseClass {

    public WebDriver driver;
    public LoginPage loginPage;
    public AddNewCustomerPage addNewCustomerPage;

   public static String randomString(){

        String generatedString= RandomStringUtils.randomAlphabetic(5);
        return (generatedString);
    }
}
