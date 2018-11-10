package com.neuedu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    private static Properties properties=new Properties();
    static {
        InputStream in=PropertiesUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String DRIVER=properties.getProperty("driver");
    public static final String URL=properties.getProperty("url");
    public static final String USERNAME=properties.getProperty("username");
    public static final String PASSWORD=properties.getProperty("password");

}
