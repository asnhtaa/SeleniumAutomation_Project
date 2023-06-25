package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {
    @Test
    public void textContextMenuSuccessful(){
        var contextMenu = homePage.clickContextMenu();
        contextMenu.clickContextMenu();
        Assert.assertEquals(contextMenu.getAlertText(), "You selected a context menu", "Alert text is incorrect!");
    }
}
