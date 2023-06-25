package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFramesTest extends BaseTest {
    @Test
    public void testNestedFramesSuccessful(){
        var nestedFrames = homePage.clickNestedFrames();
        Assert.assertEquals(nestedFrames.switchToUpperLeftFrame(), "LEFT", "Frame text is incorrect");
        Assert.assertEquals(nestedFrames.switchToLowerFrame(), "BOTTOM", "Frame text is incorrect!");
    }
}
