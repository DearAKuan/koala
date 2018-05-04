package com.yzbubble.koala.infrastructure;

import java.util.Properties;

public class PropertiesHolder {
    private static Properties properties = PropertiesReader.readClassPath(ConstantPool.DEFAULT_APPLICATION_PROPERTIES_CLASSPATH);

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public static void loadPropertiesByFilePath(String path) {
        properties = PropertiesReader.readFilePath(path);
    }

    public static void overridePropertiesByFilePath(String path) {
        Properties overrideProperties = PropertiesReader.readFilePath(path);
        overrideProperties.forEach((key, value) -> properties.put(key, value));
    }

    public static void overridePropertiesByClassPath(String path) {
        Properties overrideProperties = PropertiesReader.readClassPath(path);
        overrideProperties.forEach((key, value) -> properties.put(key, value));
    }

    public static Properties getProperties() {
        return properties;
    }
}
