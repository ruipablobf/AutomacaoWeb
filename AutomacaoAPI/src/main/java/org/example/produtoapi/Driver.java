package org.example.produtoapi;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Driver {
    public static WebDriver driver;

    @BeforeAll
    public static void iniciarDriver() {
        driver = new ChromeDriver(chromeOptions());

    }

    @AfterAll
    public static void fecharDriver() {
        driver.quit();
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        return options;
    }
}
