package io.github.bonigarcia;

import io.github.bonigarcia.webpages.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SeleniumJupiter.class)
public class BlazeTest {
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
    public void applyAsFlight() {
        HomePage home = new HomePage(driver);
        assertTrue(home.isPageOpened());
        home.clickOnFindFlightsButton();
        ReservePage reservePage = new ReservePage(driver);
        assertTrue(reservePage.isPageOpened());
        reservePage.clickOnFlightButton();
        PurchaseInfoPage applyPage = new PurchaseInfoPage(driver);
        assertTrue(applyPage.isPageOpened());

        applyPage.setName("Thiago Brasil");
        applyPage.setAddress("Rua do Loureiro, 4");
        applyPage.setCity("Recife");
        applyPage.setState("Brasil");
        applyPage.setZipCode("3810-187");
        applyPage.setCreditCardNumber("7878787878");
        applyPage.setCreditCardMonth("12");
        applyPage.setCreditCardYear("2023");
        applyPage.setNameOnCard("Thiago S. Brasil");

        applyPage.clickOnPurchaseFlightButton();
    }

    @AfterEach
    public void close(){
        driver.close();
    }
}
