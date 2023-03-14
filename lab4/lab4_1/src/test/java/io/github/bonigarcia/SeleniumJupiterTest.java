package io.github.bonigarcia;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.slf4j.LoggerFactory.getLogger;
import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertTrue;



import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SeleniumJupiter.class)
public class SeleniumJupiterTest {



    @Test
//    @Disabled
    public void blazeInstance(FirefoxDriver driver) {


        driver.get("https://blazedemo.com/");
        driver.manage().window().setSize(new Dimension(1314, 741));

        assertEquals("BlazeDemo", driver.getTitle(), "Home Page title did not match expected");

        driver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(1) > option:nth-child(7)")).click();
        driver.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(5)")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();

        assertEquals("BlazeDemo - reserve", driver.getTitle(), "Reserve Page title did not match expected");

        driver.findElement(By.cssSelector("tr:nth-child(2) .btn")).click();

        assertEquals("BlazeDemo Purchase", driver.getTitle(), "Purchase Page title did not match expected");

        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("Thiago S. Brasil");
        driver.findElement(By.id("address")).sendKeys("Rua do Loureiro, 4");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Recife");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).sendKeys("Pernambuco");
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("3810-187");
        driver.findElement(By.id("cardType")).click();
        {
            WebElement dropdown = driver.findElement(By.id("cardType"));
            dropdown.findElement(By.xpath("//option[. = 'American Express']")).click();
        }
        driver.findElement(By.cssSelector("option:nth-child(2)")).click();
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("78787878787878");
        driver.findElement(By.id("creditCardMonth")).click();
        driver.findElement(By.id("creditCardMonth")).sendKeys("02");
        driver.findElement(By.id("creditCardYear")).click();
        driver.findElement(By.id("creditCardYear")).sendKeys("2023");
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys("Thiago S. Brasil");
        driver.findElement(By.cssSelector(".checkbox")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();

        assertEquals("BlazeDemo Confirmation", driver.getTitle(), "Confirmation Page title did not match expected");
    }


}
