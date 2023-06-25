package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoad1Test extends BaseTest {
    @Test
    public void dynamicLoad1Successful(){
        var dynamicLoad = homePage.clickDynamicLoad();
        var dynamicLoad1 = dynamicLoad.clickDynamicLoad2();
        dynamicLoad1.clickStartButton();
        Assert.assertEquals(dynamicLoad1.getLoadedText(), "Hello World!", "Loaded Text is incorrect");
    }
}
