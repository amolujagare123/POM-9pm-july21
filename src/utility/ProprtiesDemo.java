package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProprtiesDemo {

    public static void main(String[] args) throws IOException {

        // 1 . read the file
        FileInputStream fp = new FileInputStream("config/test.properties");

        //2. create the object of properties class and load it with the file
        // object
        Properties prop = new Properties();
        prop.load(fp);

        // 3. read the value of key using loaded properties object
        System.out.println(prop.getProperty("project"));


    }
}
