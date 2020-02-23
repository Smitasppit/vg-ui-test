package com.ui.core;

import com.ui.utils.PropertyController;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private Logger logger = Logger.getLogger(DriverFactory.class);

    WebDriver getDriverVersion() {
        WebDriver driver;

        String driverVersion = System.getProperty("browser").toLowerCase();
        switch (driverVersion) {
            case "chrome":
                if (System.getProperty(PropertyController.CHROMEPATH) == null ||
                        System.getProperty(PropertyController.CHROMEPATH).isEmpty()) {
                    System.setProperty(PropertyController.CHROMEPATH, PropertyController.readProperty(PropertyController.CHROMEPATH));
                }
                System.out.println("Inside chrome driver");
                driver = new ChromeDriver();
                break;
            case "firefox":
               if (System.getProperty(PropertyController.FIREFOXPATH) == null ||
                        System.getProperty(PropertyController.FIREFOXPATH).isEmpty()) {
                    System.setProperty(PropertyController.FIREFOXPATH, PropertyController.readProperty(PropertyController.FIREFOXPATH));
                }
                System.out.println("Inside firefox driver");
                driver = new FirefoxDriver();
                break;
            case "chromeRemote":
                System.out.println("Inside chromeRemote driver");
                DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
                driver = null;
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Inside default driver");
                System.setProperty(PropertyController.CHROMEPATH, PropertyController.readProperty(PropertyController.CHROMEPATH));
                driver = new ChromeDriver();
        }
        return driver;
    }

    private String readDriverVersion() {
        String version;
        version = PropertyController.readProperty(PropertyController.WEBRDIVER);
        return version;
    }


}
