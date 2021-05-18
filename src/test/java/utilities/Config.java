package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties property = new Properties();


    static{
        String path = "configuration.properties";

        try{
            FileInputStream file = new FileInputStream(path);
            property.load(file);
            file.close();
        }
        catch (IOException e){
            System.out.println("Properties file not found");
        }
    }


    public static String getProperty(String keyword){

        return property.getProperty(keyword);
    }

}
