package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import utilities.DataProviderClass;

public class InfiniteScrollTest extends BaseTest {
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "test")
    public void testJavaScriptScrollSuccessful(double textBlockNum){
        var infiniteScroll = homePage.clickInfiniteScroll();
        infiniteScroll.scrollIntoTextBlock((int)textBlockNum);
    }
}
