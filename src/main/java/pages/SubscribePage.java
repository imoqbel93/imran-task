package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscribePage {

    public SubscribePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".trial-card")
    WebElement trialCard;

    @FindBy(css = ".trial-cost")
    WebElement priceTrialCard;

    @FindBy(css = ".plan-section")
    WebElement planPackages;

    @FindBy(id = "currency-lite")
    WebElement packageLite;

    @FindBy(id = "currency-classic")
    WebElement packageClassic;

    @FindBy(id = "currency-premium")
    WebElement packagePremium;

    public boolean checkTrailCardsDisplays(){
        return trialCard.isDisplayed();
    }

    public String getPriceTrailCardsValue(){
        return priceTrialCard.getText().toString().trim();
    }

    public boolean checkPlanPackagesDisplays(){
        return planPackages.isDisplayed();
    }

    public String getPricePlanPackageLite(){
        return packageLite.getText().toString().trim();
    }

    public String getPricePlanPackageClassic(){
        return packageClassic.getText().toString().trim();
    }

    public String getPricePlanPackagePremium(){
        return packagePremium.getText().toString().trim();
    }
}
