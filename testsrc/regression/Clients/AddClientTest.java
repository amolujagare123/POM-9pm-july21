package regression.Clients;

import Util.DoLogin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Login;
import pages.Menu;

import java.io.IOException;

import static utility.ConfigReader.*;

public class AddClientTest extends DoLogin {


    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setName("Abhijit1");
        addClient.setSurname("Banerjee");
        addClient.setLanguage("Swedish");
        addClient.setAddress1("xyz");
        addClient.setAddress2("pqr");
        addClient.setCity("pune");
        addClient.setState("MH");
        addClient.setZip("89898");
        addClient.setCountry("India");
        addClient.setPhone("98989");
        addClient.setFax("98989");
        addClient.setMobile("98989");
        addClient.setEmail("a@b.com");
        addClient.setWeb("www.abc.com");
        addClient.setGender("Male");
        addClient.setDateTextBox("01/05/1982"); // MM/dd/yyy
        addClient.setVat("9090232");
        addClient.setTax("9090232");
        addClient.clickSave();
    }
}
