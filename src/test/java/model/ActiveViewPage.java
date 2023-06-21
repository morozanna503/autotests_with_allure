package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import model.base.BaseMainHeaderPage;
import runner.*;
import runner.order.TestUtils;

public class ActiveViewPage extends BaseMainHeaderPage<ActiveViewPage> {
    public ActiveViewPage(WebDriver driver) {
        super(driver);
    }

    public String getActiveViewName() {

        return TestUtils.getText(this, getDriver().findElement(By.xpath("//div[@class = 'tab active']")));
    }
}
