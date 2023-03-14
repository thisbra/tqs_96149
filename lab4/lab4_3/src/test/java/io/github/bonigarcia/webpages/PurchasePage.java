package io.github.bonigarcia.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SeleniumJupiter.class)
public class PurchasePage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/h2")
    private WebElement heading;

    @FindBy(how = How.LINK_TEXT, linkText = "Purchase Flight")
    private WebElement purchaseFlightButton;

    public PurchasePage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(){
        return heading.getText().contains("Your flight from TLV to SFO has been reserved.");
    }

    public void clickOnPurchaseFlightButton(){
        purchaseFlightButton.click();
    }



}
