package com.sunland.utils;

import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class EnvUtils extends PropertySourcesPlaceholderConfigurer {
    private static Logger logger = Logger.getLogger(EnvUtils.class);
    private static Properties prop;

    public EnvUtils() {
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

    public void init() throws IOException {
        try {
            if (prop == null) {
                prop = super.mergeProperties();
            } else {
                prop.putAll(super.mergeProperties());
            }

        } catch (IOException var2) {
            logger.error("load properties error", var2);
            throw new IOException("load properties error");
        }
    }
}