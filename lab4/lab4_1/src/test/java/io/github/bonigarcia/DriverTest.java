package io.github.bonigarcia;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.slf4j.LoggerFactory.getLogger;
import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DriverTest {

    static final Logger log = getLogger(lookup().lookupClass());

    WebDriver driver;

    @BeforeAll
    static void setup() {
        System.setProperty("webdriver.chrome.driver","/home/thisbra/Downloads/chromedriver");
    }
    @BeforeEach
    void create() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    void test() {
        String setUrl = "https://bonigarcia.dev/selenium-webdriver-java/";

        driver.get(setUrl);

        String title = driver.getTitle();

        log.debug("The title of {} is {}", setUrl, title);

        assertEquals("Hands-On Selenium WebDriver with Java", title);

    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

}
