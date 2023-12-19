package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {


    public WebDriver ldriver;
    public AddNewCustomerPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    By customerIcon= By.xpath("//i[@class='nav-icon far fa-user']/following-sibling::p");
    By customerOption= By.xpath("(//i[@class='nav-icon far fa-dot-circle']/following-sibling::p[contains(text(),' Customers')])[1]");
    By addNew= By.xpath("//a[@class='btn btn-primary']");
    By email= By.xpath("//input[@id='Email']");
    By password= By.xpath("//input[@id='Password']");
    By customerDropdown= By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[2]");
    By CustomerDropdownOption= By.xpath("//li[contains(text(),'Guests')]");
    By CustomerDropDownDeleteOption=By.xpath("(//span[@title='delete'])[2]");
    By vendorDropdown= By.xpath("//select[@id='VendorId']");
    By vendorDropdownOption= By.xpath("//option[contains(text(),'Vendor 2')]");
    By gender= By.xpath("//input[@id='Gender_Male']");
    By firstName1= By.xpath("//input[@id='FirstName']");
    By lastName1=By.xpath("//input[@id='LastName']");
    By textdob= By.xpath("//input[@id='DateOfBirth']");
    By companyName= By.xpath("//input[@id='Company']");
    By adminContent= By.xpath("//textarea[@name='AdminComment']");
    By save= By.xpath("//button[@name='save']");


    public String getTitle(){
        return ldriver.getTitle();
    }

    public void customerIcon(){
        ldriver.findElement(customerIcon).click();
    }
    public void customerOptions() throws InterruptedException {
        Thread.sleep(3000);
        ldriver.findElement(customerOption).click();
    }

    public void addNew(){
        ldriver.findElement(addNew).click();
    }

    public void email(String emailId){
        ldriver.findElement(email).sendKeys(emailId);
    }

    public void password(String pswd){
        ldriver.findElement(password).sendKeys(pswd);
    }

    public void customerDD(){
        ldriver.findElement(customerDropdown).click();
    }

    public void customerDropdownOption(){
        ldriver.findElement(CustomerDropdownOption).click();
        ldriver.findElement(CustomerDropDownDeleteOption).click();
    }

    public void vendorDropdown(){
        ldriver.findElement(vendorDropdown).click();
    }

    public void vendorDropdownOption(){
        ldriver.findElement(vendorDropdownOption).click();
    }

    public void gender(){
        ldriver.findElement(gender).click();
    }

    public void setFirstName(String firstName){
        ldriver.findElement(firstName1).sendKeys(firstName);
    }

    public void setLastName(String lastName){
        ldriver.findElement(lastName1).sendKeys(lastName);
    }

    public void dateOfBirth(String dob){
        ldriver.findElement(textdob).sendKeys(dob);
    }

    public void setCompanyName(String compName){
        ldriver.findElement(companyName).sendKeys(compName);
    }

    public void adminContent(String adminText){
        ldriver.findElement(adminContent).sendKeys(adminText);
    }

    public void save(){
        ldriver.findElement(save).click();
    }
}
