package DatabaseTesting;

import Util.DoLogin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Menu;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

import static utility.Conversion.*;
import static utility.DataProviderClass.getMyData;

public class AddClientTestDataProvider extends DoLogin {


    @Test (dataProvider ="getData")
    public void addClientTest(String name,String surname,
                              String language,String address1,String address2,String city ,
                              String state ,String zip,String country,String phone,String fax,
                              String email,String web,String mobile,String gender,
                              String birthdate,String vat,String tax) throws ClassNotFoundException, SQLException, ParseException {

        ArrayList<String> expected = new ArrayList<>();
        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(address1);
        expected.add(address2);
        expected.add(city );
        expected.add(state );
        expected.add(zip);
        expected.add(country);
        expected.add(phone);
        expected.add(fax);
        expected.add(email);
        expected.add(web);
        expected.add(mobile);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(vat);
        expected.add(tax);



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

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url ="jdbc:mysql://localhost:3306/ip";
        String user = "root";
        String pass ="root";

        Connection con = DriverManager.getConnection(url,user,pass);

        Statement st = con.createStatement();

        String sql = "SELECT * FROM  ip_clients where client_name='"+name+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));


            String countryShort =  rs.getString("client_country"); // IN

            String fullFormCountry = convertCountry(countryShort);


            actual.add(fullFormCountry);



            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_mobile"));


            actual.add(genderConversion(rs.getString("client_gender")));


            actual.add(convertDate(rs.getString("client_birthdate")));

            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected);

    }


    @DataProvider
    public Object[][] getData() throws IOException {
      return getMyData("Data/myDataInvoiceplane.xlsx","DbTesting");
    }
}
