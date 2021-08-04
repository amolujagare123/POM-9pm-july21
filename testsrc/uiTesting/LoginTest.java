package uiTesting;

import Util.OpenUrl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;

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


}
