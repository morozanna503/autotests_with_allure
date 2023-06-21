package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.base.BaseMainHeaderPage;
import runner.*;
import runner.order.TestUtils;

import java.util.ArrayList;
import java.util.List;

public class ViewPage extends BaseMainHeaderPage<ViewPage> {

    @FindBy(xpath = "//tbody/tr/td/a/span")
    private List<WebElement> jobList;

    @FindBy(xpath = "//a[@id='description-link']")
    private WebElement addDescriptionButton;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement descriptionTextarea;

    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement saveDescriptionButton;

    @FindBy(xpath = "//div[@id='description']/child::*")
    private WebElement descriptionText;

    @FindBy(xpath = "//div[@class = 'tab active']")
    private WebElement activeViewTab;

    @FindBy(xpath = "//a[@href='/newView']")
    private WebElement createViewIcon;

    @FindBy(xpath = "//a[@href='delete']")
    private WebElement deleteView;

    public ViewPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getJobList() {
        return jobList;
    }

    public ViewPage clickAddDescription() {
        addDescriptionButton.click();
        return this;
    }

    public ViewPage inputDescText(String desc) {
        new Actions(getDriver()).
                click(descriptionTextarea).
                sendKeys(desc).
                perform();
        return this;
    }

    public ViewPage saveDescription() {
        saveDescriptionButton.click();
        return this;
    }

    public String getDescriptionText() {
        return descriptionText.getText();
    }

    public String getJobName(String name) {

        return getDriver().findElement(By.xpath(String.format("//a[@href='job/%s/']", name))).getText();
    }

    public String getViewName() {
        return TestUtils.getText(this, activeViewTab);
    }

    public NewViewPage createNewView() {
        getWait5().until(ExpectedConditions.elementToBeClickable(createViewIcon)).click();

        return new NewViewPage(getDriver());
    }

    public List<String> getJobNamesList() {
        if (getJobList().size() > 0) {
            getWait10().until(ExpectedConditions.visibilityOfAllElements(getJobList()));
            List<String> textList = new ArrayList<>();
            for (WebElement element : getJobList()) {
                textList.add(element.getText());
            }
            return textList;
        }
        return null;
    }

    public ViewPage clickDropDownMenuFolder(String folderName) {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//tr[@id='job_%s']//a", folderName)))).click();
        return this;
    }

    public NewJobPage selectNewItemInDropDownMenu(String viewName, String folderName) {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//a[@href='/view/%s/job/%s/newJob']", viewName, folderName)))).click();
        return new NewJobPage(getDriver());
    }

    public ViewConfigPage clickEditView(String nameProject) {
        getWait2().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format("//*[@href='/view/%s/configure']", nameProject.replaceAll(" ","%20"))))).click();
        return new ViewConfigPage(new ViewPage(getDriver()));
    }

    public DeletePage<MainPage> clickDeleteView() {
        getWait5().until(ExpectedConditions.elementToBeClickable(deleteView)).click();
        return new DeletePage<>(new MainPage(getDriver()));
    }
}
