package testcases;

import base.BaseTest;
import org.testng.annotations.Test;

public class LargeAndDeepDOMTest extends BaseTest {
    @Test
    public void testJavaScriptScrollSuccessful(){
        var largeAndDeepDOM = homePage.clickLargeAndDeepDOM();
        largeAndDeepDOM.scrollToTable();
    }
}
