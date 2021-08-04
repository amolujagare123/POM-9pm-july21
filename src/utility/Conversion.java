package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String convertCountry(String shortCounty)
    {
        String fullFormCountry="";

        switch (shortCounty)
        {
            case "IN" : fullFormCountry = "India";break;
            case "AF" : fullFormCountry = "Afghanistan";break;
            case "CN" : fullFormCountry = "China";break;
            case "AO" : fullFormCountry = "Angola";break;
            case "IE" : fullFormCountry = "Ireland";break;
        }

        return fullFormCountry;
    }

    public static String genderConversion(String genderID)
    {
        String gender ="";
        switch (genderID)
        {
            case "0" : gender="Male";break;
            case "1" : gender="Feale";break;
            case "2" : gender="Other";break;
        }
        return  gender;
    }

   /* Expected :01/05/1982 --> MM/dd/yyyy
    Actual   :1982-01-05*/ // -->  yyyy-MM-dd

    public static String convertDate(String dbDate) throws ParseException // yyyy-dd-MM
    {
        String convertedDate = "";

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDate);

        convertedDate = new SimpleDateFormat("MM/dd/yyyy").format(date);

        return  convertedDate;

    }
}
