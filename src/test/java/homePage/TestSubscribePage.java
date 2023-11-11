package homePage;

import moules.Subscribe;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.ConfigsWebDriver;
import utils.Countries;

public class TestSubscribePage extends Countries {

    String country;
    ConfigsWebDriver driver;
    Subscribe subscribe;

    @Factory(dataProvider = "dataCountries")
    public TestSubscribePage(String country){
        this.country = country;
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ConfigsWebDriver();
        subscribe = new Subscribe(driver.getWebDriver());
        driver.getWebDriver().get("https://subscribe.jawwy.tv/" + country);
    }

    @Test(description = "Check the Trail cards appears on subscribe page")
    public void testVerifyGiftCard(){
        if ("sa-en kw-en bh-en".contains(country)) {
            throw new SkipException("Skipping this exception as its not supported for (" + country + ") Country.");
        }
        Assert.assertTrue(subscribe.checkTrailCardsDisplays(), "Trail card not displays for " + country + " country.");
        Assert.assertEquals(subscribe.getPriceTrailCardsValue(),  subscribe.getExpectedPriceTrailCards(country));
    }

    @Test(description = "Check the Plan Packages appears on subscribe page")
    public void testVerifyPlanPackages(){
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(subscribe.checkPlanPackagesDisplays(), "Plan Packages not displays for " + country + " country."); // no need to soft assert here as if packages are not visible no need to continue
        softAssert.assertEquals(subscribe.getPricePlanPackageLite(), subscribe.getExpectedPricePackage(country, "packageLite"));
        softAssert.assertEquals(subscribe.getPricePlanPackageClassic(), subscribe.getExpectedPricePackage(country, "packageClassic"));
        softAssert.assertEquals(subscribe.getPricePlanPackagePremium(), subscribe.getExpectedPricePackage(country, "packagePremium"));
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println(country);
        driver.getWebDriver().quit();
    }
}
