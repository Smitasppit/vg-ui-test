package com.ui.core;

import com.ui.utils.PropertyController;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverProvider {
    private static Logger logger = Logger.getLogger(DriverProvider.class);
    private static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();

    private DriverProvider(){}

    public static WebDriver getDriver(){
        if (driverInstance.get() ==null){
            DriverFactory driverFactory = new DriverFactory();
            driverInstance.set(driverFactory.getDriverVersion());
        }
        return driverInstance.get();
    }
    public static String getBaseurl() {
        String baseurl;
        baseurl = PropertyController.readProperty(PropertyController.BASEURL);
        logger.info("Baseurl" + baseurl);
        return baseurl;
    }

    public static void closeDriver() {
        if (driverInstance.get() != null) {
            driverInstance.get().close();
            driverInstance.get().quit();
            driverInstance.set(null);
        }
    }
}
