package regression.Clients;

import Util.DoLogin;
import Util.OpenUrl;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Login;
import pages.Menu;

import java.io.IOException;

import static utility.ConfigReader.*;
import static utility.DataProviderClass.getMyData;

public class AddClientTestDataProvider extends DoLogin {


    @Test (dataProvider ="getData")
    public void addClientTest(String name,String surname,
                              String language,String address1,String address2,String city ,
                              String state ,String zip,String country,String phone,String fax,
                              String email,String web,String mobile,String gender,
                              String birthdate,String vat,String tax,String expected,String xpathActual)
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setName(name);
        addClient.setSurname(surname);
        addClient.setLanguage(language);
        addClient.setAddress1(address1);
        addClient.setAddress2(address2);
        addClient.setCity(city);
        addClient.setState(state);
        addClient.setZip(zip);
        addClient.setCountry(country);
        addClient.setPhone(phone);
        addClient.setFax(fax);
        addClient.setMobile(mobile);
        addClient.setEmail(email);
        addClient.setWeb(web);
        addClient.setGender(gender);
        addClient.setDateTextBox(birthdate); // MM/dd/yyy
        addClient.setVat(vat);
        addClient.setTax(tax);
        addClient.clickSave();

        String actual ="";
        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
       catch (Exception e)
       {

       }

        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);
        Assert.assertEquals(actual,expected,"wrong message");

    }


    @DataProvider
    public Object[][] getData() throws IOException {
      return getMyData("Data/myDataInvoiceplane.xlsx","Sheet1");
    }
}
