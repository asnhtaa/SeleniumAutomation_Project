package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviderClass;

public class HorizontalSliderTest extends BaseTest {
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "test")
    public void horizontalSliderSuccessful(double horizontal, double vertical){
        var horizontalSlider = homePage.clickHorizontalSlider();
        horizontalSlider.setSlider((int)horizontal,(int)vertical);
        Assert.assertEquals(horizontalSlider.getRangeIndicator(), "4", "Range indicator is incorrect");
    }
}
