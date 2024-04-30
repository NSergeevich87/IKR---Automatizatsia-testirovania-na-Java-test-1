package com.max;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UITest {
    public static WebDriver driver;
    @BeforeAll
    public static void setupWebDriver() {

        AbstractClass abstractClass = new AbstractClass();
        abstractClass.setupDriver();
        driver = new ChromeDriver(abstractClass.options);
    }
    @BeforeEach
    public void waitAndGetPage() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://gb.ru/login");
    }
    @Test
    void testGBNotEmailLogin() {

        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/input")).sendKeys("login");
        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[2]/input")).sendKeys("password");
        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[4]/input")).click();

        Assertions.assertFalse(driver.findElements(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/ul")).isEmpty());
    }

    @Test
    void testGBWithoutPassword() {

        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/input")).sendKeys("login@login.ru");
        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[4]/input")).click();

        Assertions.assertFalse(driver.findElements(By.xpath("/html/body/div[2]/div[7]/div/form/div[2]/ul")).isEmpty());
    }
}
