package uiTesting;

import Util.OpenUrl;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;

import java.util.Locale;

public class LoginTest extends OpenUrl {

    Login login;

    @BeforeClass
    public void initLoginObject()
    {
        login = new Login(driver);
    }

    @Test
    public void txtUsernameVisibility()
    {
        boolean expected = true;
        boolean actual = false;
        try {
             actual = login.txtUsername.isDisplayed(); // true /false
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"username element not fount");
    }

    @Test
    public void txtUsernameEnability()
    {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.txtUsername.isEnabled(); // true /false
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"username element not enabled");
    }

    @Test
    public void lblLoginSpellCheck()
    {
     String expected = "Login";
        String actual = "";
     try {
        actual = login.lblLogin.getText();
     }
     catch (Exception e)
     {

     }
     Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void lblPasswordFontSize()
    {
        String expected = "14px";
        String actual = "";
        try {
            actual = login.lblPass.getCssValue("font-size");
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void txtPasswordWatermark()
    {
        String expected = "Password";
        String actual = "";
        try {
            actual = login.txtPassword.getAttribute("placeholder");
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void lblPasswordFontFamily()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";

        String actual = "";
        try {
            actual = login.lblPass.getCssValue("font-family");
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void lblPasswordFont()
    {
        String expected = "sans-serif";

        String actual = "";
        try {
            actual = login.lblPass.getCssValue("font-family");
        }
        catch (Exception e)
        {

        }

        boolean result = actual.contains(expected);

        Assert.assertTrue(result,"the font is not there in the font family");
    }

    @Test
    public void iconButtonCheck()
    {
        String expected= "unlock";

        String actual = "";
        try {
            actual = login.iconButton.getAttribute("class");
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        boolean result = actual.contains(expected);

        Assert.assertTrue(result,"the font is not there in the font family");

    }


    @Test
    public void btnLoginColor()
    {
        String expected = "#2C8EDD";

        String actual = "";
        try {

            String rgbColor = login.btnLogin.getCssValue("background-color");

            actual =Color.fromString(rgbColor).asHex().toUpperCase();

        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"");
    }

}
