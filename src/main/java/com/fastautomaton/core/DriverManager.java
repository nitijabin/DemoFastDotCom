package com.fastautomaton.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager implements IDriver {

    private String browserName;

    public DriverManager(String browserName) {
        this.browserName = browserName;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("disable-infobars");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-gpu");
        if (System.getProperty("headless") == null || Boolean.parseBoolean(System.getProperty("headless"))) {
            //  options.addArguments("--headless");
        }
        return options;
    }

    @Override
    public WebDriver createDriver() {
        switch (browserName.toLowerCase()) {
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                return new ChromeDriver(getChromeOptions());
        }
    }
}
