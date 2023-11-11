package utils;

import org.testng.annotations.DataProvider;

public class Countries {

    @DataProvider(name = "dataCountries")
    protected static Object[][] getCountries(){
        return new Object[][] {{"jo-en"}, {"om-en"}, {"ae-en"}, {"sa-en"}, {"bh-en"}, {"kw-en"}};
    }
}
