package com.max;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class AbstractClass {
    public static ChromeOptions options;
    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
    }
}
