package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.base.BaseMainHeaderPage;
import runner.*;
import runner.order.TestUtils;

import java.util.List;

public class ManagePluginsPage extends BaseMainHeaderPage<ManagePluginsPage> {

    @FindBy(xpath = "//div[@id='tasks']//div[not(contains(@class, 'subtask'))]")
    private List<WebElement> fourTasksOnTheLeftsidePanel;

    @FindBy(xpath = "//*[@id='tasks']/div[4]/span")
    private WebElement advancedSettings;

    public ManagePluginsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> checkFourTasksOnTheLeftsidePanel() {
        List<WebElement> listOfTasks = getWait5().until(ExpectedConditions.visibilityOfAllElements(fourTasksOnTheLeftsidePanel));

        return TestUtils.getTexts(listOfTasks);
    }

    public ManagePluginsAdvancedPage clickAdvancedSettings(){
        advancedSettings.click();
        return new ManagePluginsAdvancedPage(getDriver());
    }
}
