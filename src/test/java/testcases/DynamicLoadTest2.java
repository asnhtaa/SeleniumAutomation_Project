package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadTest2 extends BaseTest {
    @Test
    public void dynamicLoad2Successful(){
        var dynamicLoad = homePage.clickDynamicLoad();
        var dynamicLoad2 = dynamicLoad.clickDynamicLoad1();
        dynamicLoad2.clickStartButton();
        Assert.assertEquals(dynamicLoad2.getLoadedText(), "Hello World!", "Loaded Text is incorrect");
    }
}
