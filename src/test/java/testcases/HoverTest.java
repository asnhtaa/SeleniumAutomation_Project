package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Hover;

public class HoverTest extends BaseTest {
    @Test
    public void testHover1Successful(){
        Hover hoverPage = homePage.clickHoverButton();
        Hover.FigureCaption figureCaption = hoverPage.hoverOverFigure(1);
        Assert.assertTrue(figureCaption.isCaptionDisplayed(), "Caption is not displayed");
        Assert.assertEquals(figureCaption.getHeader(), "name: user1", "Header is incorrect");
        Assert.assertEquals(figureCaption.getLinkText(), "View profile", "Link text is incorrect");
        Assert.assertTrue(figureCaption.getLink().contains("users/1"));
    }
}
