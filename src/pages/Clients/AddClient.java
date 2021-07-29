package pages.Clients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {
    @FindBy(xpath = "//input[@name='client_name']")
    WebElement name;


    @FindBy (xpath = "//input[@name='client_surname']") WebElement surname;
    @FindBy (xpath = "//input[@name='client_address_1']") WebElement address1;
    @FindBy (xpath = "//input[@name='client_address_2']") WebElement address2;
    @FindBy (xpath = "//input[@name='client_city']") WebElement city;
    @FindBy (xpath = "//input[@name='client_state']") WebElement state;
    @FindBy (xpath = "//input[@name='client_zip']") WebElement zip;
    @FindBy (xpath = "//input[@name='client_phone']") WebElement phone;
    @FindBy (xpath = "//input[@name='client_fax']") WebElement fax;
    @FindBy (xpath = "//input[@name='client_mobile']") WebElement mobile;
    @FindBy (xpath = "//input[@name='client_email']") WebElement email;
    @FindBy (xpath = "//input[@name='client_web']") WebElement web;
    @FindBy (xpath = "//input[@name='client_vat_id']") WebElement vat;
    @FindBy (xpath = "//input[@name='client_tax_code']") WebElement tax;
    @FindBy (xpath = "//button[normalize-space()='Save']") WebElement btnSave;

    @FindBy (xpath = "//input[@type='search']")
    WebElement searchBox;

    @FindBy(id="select2-client_language-container")
    WebElement containerLanguage;

    WebDriver driver;
    public void setLanguage(String language)
    {
        containerLanguage.click();
        searchBox.sendKeys(language);
        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']")).click();
    }

    @FindBy(id="select2-client_country-container")
    WebElement containerCountry;

    public void setCountry(String country)
    {
        containerCountry.click();
        searchBox.sendKeys(country);
        driver.findElement(By.xpath("//li[normalize-space()='"+country+"']")).click();
    }

    @FindBy(id="select2-client_gender-container")
    WebElement containerGender;

    public void setGender(String gender)
    {
        containerGender.click();
        driver.findElement(By.xpath("//li[normalize-space()='"+gender+"']")).click();

    }

    public AddClient(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void setName(String cName)
    {
        name.sendKeys(cName);
    }

    public void setSurname(String cSurname)
    {
        surname.sendKeys(cSurname);
    }

    public void setAddress1(String cAdd1)
    {
        address1.sendKeys(cAdd1);
    }

    public void setAddress2(String cAdd2)
    {
        address2.sendKeys(cAdd2);
    }

    public void setCity(String cCity)
    {
        city.sendKeys(cCity);
    }

    public void setState(String cState)
    {
        state.sendKeys(cState);
    }

    public void setZip(String cZip)
    {
        zip.sendKeys(cZip);
    }

    public void setPhone(String cPhone)
    {
        phone.sendKeys(cPhone);
    }

    public void setFax(String cFax)
    {
        fax.sendKeys(cFax);
    }

    public void setMobile(String cMobile)
    {
        mobile.sendKeys(cMobile);
    }

    public void setEmail(String cEmail)
    {
        email.sendKeys(cEmail);
    }

    public void setWeb(String cWeb)
    {
        web.sendKeys(cWeb);
    }

    public void setVat(String cVat)
    {
        vat.sendKeys(cVat);
    }

    public void setTax(String cTax)
    {
        tax.sendKeys(cTax);
    }

    public void clickSave()
    {
        btnSave.click();
    }
}
