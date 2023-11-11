package modules;

import org.openqa.selenium.WebDriver;
import pages.SubscribePage;
import utils.CustomPropertiesFile;

public class Subscribe extends SubscribePage {


    public Subscribe(WebDriver driver) {
        super(driver);
    }

    public String getExpectedPriceTrailCards(String country) {
       return CustomPropertiesFile.getProperties(country, "subscriptionsPage", "priceTrailCards");
    }

    public String getExpectedPricePackage(String country,String packageName) {
        return CustomPropertiesFile.getProperties(country, "subscriptionsPage", packageName);
    }
}
