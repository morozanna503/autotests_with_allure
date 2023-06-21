package model.jobs;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.base.BaseProjectPage;
import model.jobsconfig.FreestyleProjectConfigPage;

public class FreestyleProjectPage extends BaseProjectPage<FreestyleProjectPage> {

    @FindBy(id = "description-link")
    private WebElement addDescriptionButton;

    @FindBy(xpath = "//*[@id='description']/form/div[2]/button")
    private WebElement saveDescriptionButton;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement descriptionTextArea;

    @FindBy(xpath = "//a[@class = 'textarea-show-preview']")
    private WebElement previewButton;

    @FindBy(xpath = "//*[@class = 'textarea-preview']")
    private WebElement descriptionPreviewButton;

    @FindBy(xpath = "//*[@id='description']/div")
    private WebElement description;

    @FindBy(xpath = "//a[@class='model-link' and contains(@href,'job')]")
    private WebElement jobOnBreadcrumbBarDropDownMenuButton;

    @FindBy(xpath = "//a[@class='model-link' and contains(@href,'job')]/button")
    private WebElement optionsBreadcrumbBarDropDownMenuButton;

    @FindBy(xpath = "//a[@class='yuimenuitemlabel' and @href='#']/span[text()='Delete Project']/..")
    private WebElement deleteButtonOnDropDownMenu;

    public FreestyleProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FreestyleProjectConfigPage clickConfigure() {
        setupClickConfigure();
        return new FreestyleProjectConfigPage(this);
    }

    public FreestyleProjectPage clickAddDescription() {
        addDescriptionButton.click();
        return this;
    }

    public FreestyleProjectPage clickSaveDescription() {
        saveDescriptionButton.click();
        return this;
    }

    public FreestyleProjectPage addDescription(String description) {
        descriptionTextArea.sendKeys(description);
        return this;
    }

    public FreestyleProjectPage removeOldDescriptionAndAddNew (String description) {
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys(description);
        return this;
    }

    public FreestyleProjectPage clickPreviewButton () {
        previewButton.click();
        return this;
    }

    public String getPreviewDescription () {
        return descriptionPreviewButton.getText();
    }

    private void  openJobOnBreadcrumbBarDropDownMenu() {
        new Actions(getDriver()).moveToElement(jobOnBreadcrumbBarDropDownMenuButton).perform();

        WebElement options = getWait2().until(
                ExpectedConditions.elementToBeClickable(optionsBreadcrumbBarDropDownMenuButton));
        new Actions(getDriver()).moveToElement(options).perform();
        options.sendKeys(Keys.RETURN);
    }

    public FreestyleProjectPage clickDeleteProjectOnDropDown() {
        openJobOnBreadcrumbBarDropDownMenu();
        getWait2().until(ExpectedConditions.visibilityOf(deleteButtonOnDropDownMenu)).click();
        return this;
    }

    public FreestyleProjectPage dismissAlert() {
        getDriver().switchTo().alert().dismiss();
        return this;
    }
}
