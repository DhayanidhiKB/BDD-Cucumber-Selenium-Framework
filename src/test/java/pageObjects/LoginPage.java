package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver ldriver;
    public LoginPage(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(id="Email")
    WebElement emailTxt;

    @FindBy(id="Password")
    WebElement pswdTxt;

    @FindBy(xpath="//button[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath="//a[contains(text(),'Logout')]")
    WebElement logoutBtn;

    public void setUserName(String userName){
        emailTxt.clear();
        emailTxt.sendKeys(userName);
    }

    public void setPswd(String password){
        pswdTxt.clear();
        pswdTxt.sendKeys(password);
    }

    public void clicklogin(){
        loginBtn.click();
    }

    public void clicklogout(){
        logoutBtn.click();
    }
}
