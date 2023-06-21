package model.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.DeletePage;
import model.MainPage;
import model.jobs.FolderPage;

public abstract class BaseOtherFoldersPage<Self extends BaseJobPage<?>> extends BaseJobPage<Self> {

    @FindBy(partialLinkText = "Delete ")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[@class='jenkins-button jenkins-button--primary ']")
    private WebElement disableButton;

    @FindBy(xpath = "//form[@method='post']")
    private WebElement disableMessage;

    @FindBy(xpath = "//div[@id='view-message']")
    private WebElement descriptionMessage;

    @FindBy(xpath = "(//*[name()='svg'][@title='Folder'])[1]")
    private WebElement defaultIcon;

    @FindBy(xpath = "//h1/img")
    private WebElement metadataFolderIcon;

    public BaseOtherFoldersPage(WebDriver driver) {
        super(driver);
    }

    public DeletePage<MainPage> clickDeleteJobLocatedOnMainPage() {
        deleteButton.click();
        return new DeletePage<>(new MainPage(getDriver()));
    }

    public DeletePage<FolderPage> clickDeleteJobLocatedOnFolderPage() {
        deleteButton.click();
        return new DeletePage<>(new FolderPage(getDriver()));
    }

    public Self clickDisableButton() {
        disableButton.click();
        return (Self)this;
    }

    public String getTextFromDisableMessage() {
        return disableMessage.getText();
    }

    public String getAddedDescriptionFromConfig() {
        return descriptionMessage.getText();
    }

    public boolean isDefaultIconDisplayed() {
        return getWait5().until(ExpectedConditions.visibilityOf(defaultIcon)).isDisplayed();
    }

    public boolean isMetadataFolderIconDisplayed() {
        return getWait5().until(ExpectedConditions.visibilityOf(metadataFolderIcon)).isDisplayed();
    }
}
