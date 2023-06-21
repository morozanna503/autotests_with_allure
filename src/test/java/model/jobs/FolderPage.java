package model.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.*;
import model.base.BaseJobPage;
import model.jobsconfig.FolderConfigPage;
import runner.*;
import runner.order.TestUtils;

import java.util.List;

public class FolderPage extends BaseJobPage<FolderPage> {

    @FindBy(css = "#tasks>:nth-child(3)")
    private WebElement buttonNewItem;

    @FindBy(xpath = "//div[@class='tab']")
    private WebElement buttonNewView;

    @FindBy(partialLinkText = "Delete ")
    private WebElement deleteButton;

    @FindBy(id = "view-message")
    private WebElement folderDescription;

    @FindBy(css = ".jenkins-table__link")
    private List<WebElement> jobList;

    public FolderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FolderConfigPage clickConfigure() {
        setupClickConfigure();
        return new FolderConfigPage(new FolderPage(getDriver()));
    }

    public NewJobPage clickNewItem() {
        buttonNewItem.click();
        return new NewJobPage(getDriver());
    }

    public NewViewFolderPage clickNewView() {
        buttonNewView.click();
        return new NewViewFolderPage(getDriver());
    }

    public DeletePage<MainPage> clickDeleteJobThatIsMainPage() {
        deleteButton.click();
        return new DeletePage<>(new MainPage(getDriver()));
    }

    public DeletePage<FolderPage> clickDeleteJobThatIsFolderPage() {
        deleteButton.click();
        return new DeletePage<>(new FolderPage(getDriver()));
    }

    public String getFolderDescription() {
        return TestUtils.getText(this, folderDescription);
    }

    public boolean nestedFolderIsVisibleAndClickable(String nestedFolder) {
        return getWait5().until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[contains(@href,'job/" + nestedFolder + "/')]"))).isDisplayed()
                && getWait5().until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[contains(@href,'job/" + nestedFolder + "/')]"))).isEnabled();
    }

    public boolean viewIsDisplayed(String viewName){
       return getDriver().findElement(By.linkText(viewName)).isDisplayed();
    }

    public List<String> getJobList() {
        return jobList
                .stream()
                .map(WebElement::getText)
                .toList();
    }
}
