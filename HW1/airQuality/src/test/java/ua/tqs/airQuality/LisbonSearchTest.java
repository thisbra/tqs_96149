package ua.tqs.airQuality;


import java.io.File;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class LisbonSearchTest {


    WebDriver driver;

    @BeforeAll
    static void setup() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
    }
    @BeforeEach
    void create() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }


    @Test
    @Disabled
    public void lisbonSearch() {
        // Test name: lisbonSearch
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("http://localhost:8080/");
        // 2 | setWindowSize | 621x695 |
        driver.manage().window().setSize(new Dimension(621, 695));
        // 3 | click | id=inputCity |
        driver.findElement(By.id("inputCity")).click();
        // 4 | type | id=inputCity | lisbon
        driver.findElement(By.id("inputCity")).sendKeys("lisbon");
        // 5 | click | css=.btn |
        driver.findElement(By.cssSelector(".btn")).click();

        assertEquals(driver.findElement(By.id("cityName")).getText(), "lisbon");

    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

}