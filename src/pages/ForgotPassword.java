package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {

    @FindBy (xpath = "//input[@type='text']")
    WebElement txtForgotPass;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement btnReset;

    public ForgotPassword(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void  setTxtForgotPass(String email)
    {
        txtForgotPass.sendKeys(email);
    }

    public void clickReset()
    {
        btnReset.click();
    }
}
