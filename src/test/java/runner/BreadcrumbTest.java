package runner;

import model.MainPage;
import model.PluginsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.order.BaseTest;

import java.util.Arrays;
import java.util.List;

public class BreadcrumbTest extends BaseTest {

    @Test
    public void testDashboardDropdownMenu() {
        final List<String> expectedMenuList = Arrays.asList("New Item", "People", "Build History", "Manage Jenkins", "My Views");

        List<String> actualMenuList = new MainPage(getDriver())
                .getBreadcrumb()
                .getDashboardDropdownMenu()
                .getMenuList();

        Assert.assertEquals(actualMenuList, expectedMenuList);
    }

    @Test
    public void testMoveFromPeoplePageToPluginsPageByDropDownMenu() {
        String actualTitle = new MainPage(getDriver())
                .clickPeopleOnLeftSideMenu()
                .getBreadcrumb()
                .selectAnOptionFromDashboardManageJenkinsSubmenuList("Manage Plugins", new PluginsPage(getDriver()))
                .getPageTitle();

        Assert.assertEquals(actualTitle, "Plugins");
    }

    @Test
    public void testMoveFromBuildHistoryPageToPeoplePageByDropDownMenu() {
        String actualTitle = new MainPage(getDriver())
                .clickBuildsHistoryButton()
                .getBreadcrumb()
                .openPeoplePageFromDashboardDropdownMenu()
                .getPageTitle();

        Assert.assertEquals(actualTitle, "People");
    }

}
