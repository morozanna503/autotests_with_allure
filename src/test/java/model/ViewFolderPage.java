package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.base.BaseMainHeaderPage;
import model.jobs.FolderPage;

public class ViewFolderPage extends BaseMainHeaderPage<ViewFolderPage> {

    @FindBy(linkText = "All")
    private WebElement allLink;

    @FindBy(xpath = "//div[@class='tab active']")
    private WebElement myViewTabBar;

    public ViewFolderPage(WebDriver driver) {
        super(driver);
    }

    public FolderPage clickAll() {
        allLink.click();

        return new FolderPage(getDriver());
    }

    public String getMyView() {
        return getWait5().until(ExpectedConditions.visibilityOf(myViewTabBar)).getText();
    }
}
