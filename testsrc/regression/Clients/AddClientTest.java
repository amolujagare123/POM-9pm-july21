package regression.Clients;

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

public class AddClientTest {
    WebDriver driver;
    @BeforeClass
    public void doLogin() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickButtonLogin();
    }

    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setLanguage("Swedish");
        addClient.setCountry("Hungary");
        addClient.setGender("Other");

        /*addClient.setName("Abhijit");
        addClient.setSurname("Banerjee");
        addClient.setAddress1("xyz");
        addClient.setAddress2("pqr");
        addClient.setCity("pune");
        addClient.setState("MH");
        addClient.setZip("89898");
        addClient.setPhone("98989");
        addClient.setFax("98989");
        addClient.setMobile("98989");
        addClient.setEmail("a@b.com");
        addClient.setWeb("www.abc.com");
        addClient.setVat("9090232");
        addClient.setTax("9090232");
        addClient.clickSave();*/
    }
}
