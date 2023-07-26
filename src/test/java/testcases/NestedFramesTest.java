package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NestedFramesTest extends BaseTest {
    @Test
    public void testNestedFramesSuccessful(){
        var nestedFrames = homePage.clickNestedFrames();
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(nestedFrames.switchToUpperLeftFrame(), "LEFT", "Frame text is incorrect");
        assertion.assertEquals(nestedFrames.switchToLowerFrame(), "BOTTOM", "Frame text is incorrect!");
    }
}
