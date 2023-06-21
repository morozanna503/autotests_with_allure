package model.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.MainPage;
import model.MovePage;
import model.RenamePage;

import java.time.Duration;

public abstract class BaseJobPage<Self extends BaseJobPage<?>> extends BaseMainHeaderPage<Self> {

    @FindBy(linkText = "Configure")
    private WebElement configureButton;

    @FindBy(css = "#main-panel>h1")
    private WebElement jobName;

    @FindBy(linkText = "Rename")
    private WebElement renameButton;

    @FindBy(partialLinkText = "Delete ")
    private WebElement deleteButton;

    @FindBy(xpath = "//a[@id='description-link']")
    private WebElement editDescriptionButton;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement descriptionField;

    @FindBy(xpath = "//div[@id='description']/div[1]")
    private WebElement jobDescription;

    @FindBy(css = "[href$='/move']")
    private WebElement moveButton;

    @FindBy(xpath = "//button[text() = 'Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@id='main-panel']")
    private WebElement mainPanel;

    public BaseJobPage(WebDriver driver) {
        super(driver);
    }

    protected void setupClickConfigure() {
        getWait10().until(ExpectedConditions.elementToBeClickable(configureButton)).click();
    }

    public abstract BaseConfigPage<?,?> clickConfigure();

    public String getJobName() {
        return getWait2().until(ExpectedConditions.visibilityOf(jobName)).getText();
    }

    public RenamePage<Self> clickRename() {
        renameButton.click();
        return new RenamePage<>((Self) this);
    }

    public MainPage clickDeleteAndAlert() {
        deleteButton.click();
        getDriver().switchTo().alert().accept();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        return new MainPage(getDriver());
    }

    public Self clickEditDescription() {
        getWait5().until(ExpectedConditions.visibilityOf(editDescriptionButton)).click();
        return (Self) this;
    }

    public Self enterDescription(String description) {
        descriptionField.sendKeys(description);
        return (Self) this;
    }

    public Self clearDescriptionField() {
        getWait5().until(ExpectedConditions.visibilityOf(descriptionField)).clear();
        return (Self) this;
    }

    public String getDescription() {
        return jobDescription.getText();
    }

    public boolean isDescriptionEmpty(){
        return jobDescription.getText().isEmpty();
    }

    public MovePage<Self> clickMoveOnSideMenu() {
        getWait5().until(ExpectedConditions.elementToBeClickable(moveButton)).click();
        return new MovePage<>((Self) this);
    }

    public Self changeDescriptionWithoutSaving(String newDescription) {
        editDescriptionButton.click();
        getWait2().until(ExpectedConditions.elementToBeClickable(descriptionField));
        descriptionField.clear();
        descriptionField.sendKeys(newDescription);
        return (Self) this;
    }

    public Self clickSaveButton() {
        saveButton.click();
        return (Self) this;
    }

    public String getProjectNameSubtitleWithDisplayName() {
        String projectName = mainPanel.getText();
        String subStr = projectName.substring(projectName.indexOf(':') + 2);
        return subStr.substring(0, subStr.indexOf("\n")).trim();
    }
}
