package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AddNewCustomerPage;
import pageObjects.LoginPage;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class steps extends BaseClass {

    @Given("User launch the Chrome browser")
    public void user_launch_the_chrome_browser() throws MalformedURLException {
       //If needed to run it locally
       /* WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();*/

        //If needed to run in docker container
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options);
    }

    @When("user launches the URL {string}")
    public void user_launches_the_url(String url) throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pswd) throws InterruptedException {
        loginPage=new LoginPage(driver);
        loginPage.setUserName(email);
        Thread.sleep(2000);
        loginPage.setPswd(pswd);
        Thread.sleep(2000);
    }

    @When("clicks on login button")
    public void clicks_on_login_button() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.clicklogin();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String title) throws InterruptedException {
        Thread.sleep(2000);
        if(driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again.No customer account found")){
            driver.close();
        }
        else{
            String pageTitle=driver.getTitle();
            System.out.println("Title of page is " +pageTitle);
        }
    }

    @When("user clicks on logout")
    public void user_clicks_on_logout() throws InterruptedException {
        Thread.sleep(5000);
        loginPage.clicklogout();
        Thread.sleep(5000);
    }

    @Then("close the browser")
    public void close_the_browser() {
        driver.close();
    }


    //Customer Feature File Methods

    @Then("user can view the dashboard")
    public void user_can_view_the_dashboard() {
        addNewCustomerPage=new AddNewCustomerPage(driver);
        String pageTitle=addNewCustomerPage.getTitle();
        System.out.println("Title of page is " +pageTitle);
    }

    @When("user click on the customer menu")
    public void user_click_on_the_customer_menu() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        addNewCustomerPage.customerIcon();
    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        addNewCustomerPage.customerOptions();
    }

    @When("click on Add new button")
    public void click_on_add_new_button() {
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        addNewCustomerPage.addNew();
    }

    @Then("user can view add new customer page")
    public void user_can_view_add_new_customer_page() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertEquals("Add a new customer / nopCommerce administration",addNewCustomerPage.getTitle());
    }

    @When("user enter customer info")
    public void user_enter_customer_info() {
        String email= RandomStringUtils.randomAlphabetic(5)+"@gmail.com";
        addNewCustomerPage.email(email);
        addNewCustomerPage.password("test123");
        addNewCustomerPage.customerDD();
        addNewCustomerPage.customerDropdownOption();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        addNewCustomerPage.vendorDropdown();
        addNewCustomerPage.vendorDropdownOption();
        addNewCustomerPage.gender();
        addNewCustomerPage.setFirstName("Praveen");
        addNewCustomerPage.setLastName("Xavier");
        addNewCustomerPage.dateOfBirth("07-05-1998");
        addNewCustomerPage.setCompanyName("Praveen Automation Labs");
        addNewCustomerPage.adminContent("Testing Purpose");
    }
    @When("click on save button")
    public void click_on_save_button() {
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        addNewCustomerPage.save();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
    }
    @Then("close browser")
    public void close_browser() {
        driver.close();
    }


}
