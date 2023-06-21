package runner;

import org.testng.Assert;
import org.testng.annotations.Test;
import model.JenkinsVersionPage;
import model.MainPage;
import runner.*;
import runner.order.BaseTest;

public class FooterTest extends BaseTest {

    @Test
    public void testJenkinsVersion() {
        String linkVersion = new MainPage(getDriver())
                .getHeader()
                .getLinkVersion();



        Assert.assertEquals(linkVersion, "Jenkins 2.387.2");
    }

    @Test
    public void testLinkJenkinsVersion() {
        String jenkinsText = new JenkinsVersionPage(getDriver())
                .switchJenkinsDocPage()
                .getJenkinsPageTitle();

        Assert.assertEquals(jenkinsText, "Jenkins");
    }

    @Test
    public void testLinkRestApi() {
        String mainPage = new MainPage(getDriver())
                .clickOnRestApiLink()
                .getRestApiPageTitle();

        Assert.assertEquals(mainPage, "REST API");
    }
}
