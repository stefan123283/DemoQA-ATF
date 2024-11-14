package com.demoqa.managers;

import java.io.*;
import java.util.Properties;

public class ConfigReaderManager {
    private static final String CONFIG_FILE_PATH = "src/main/resources/Config.properties";
    private static Properties properties;

    public static void initProperties() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(CONFIG_FILE_PATH);
            bufferedReader = new BufferedReader(fileReader);
            properties = new Properties();
            properties.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null && bufferedReader != null) {
                try {
                    fileReader.close();
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            initProperties();
        }
        return properties.getProperty(key);
    }
}