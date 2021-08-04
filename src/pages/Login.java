package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    @FindBy (xpath = "//input[@id='email']")
    public WebElement txtUsername;

    //WebElement txtUsername =  driver.findElement(By.xpath("//input[@id='email']"));

    @FindBy (xpath = "//input[@id='password']")
    public WebElement txtPassword;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement btnLogin;

    @FindBy (xpath = "//a[normalize-space()='I forgot my password']")
    public WebElement lnkForgotPass;

    @FindBy (xpath = "//h1")
    public  WebElement lblLogin;

    @FindBy (xpath = "//label[@for='email']")
    public  WebElement lblEmail;


    @FindBy (xpath = "//label[@for='password']")
    public WebElement lblPass;

    public void clickForgotPass()
    {
        lnkForgotPass.click();
    }


    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setTxtUsername(String user)
    {
        txtUsername.sendKeys(user);
    }

    public void setTxtPassword(String pass)
    {
        txtPassword.sendKeys(pass);
    }
    public void clickButtonLogin()
    {
        btnLogin.click();
    }

}
