package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.base.BaseMainHeaderPage;

public class StatusUserPage extends BaseMainHeaderPage<StatusUserPage> {

    @FindBy(id = "description-link")
    private WebElement addEditDescriptionLink;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement addDescriptionInput;

    @FindBy(xpath = "//div[@id='description']/div[1]")
    private WebElement descriptionText;

    @FindBy(name = "Submit")
    private WebElement saveButton;

    public StatusUserPage(WebDriver driver) {
        super(driver);
    }

    public StatusUserPage clickAddDescriptionLink() {
        addEditDescriptionLink.click();

        return this;
    }

    public StatusUserPage addDescription(String text) {
        addDescriptionInput.clear();
        addDescriptionInput.sendKeys(text);

        return this;
    }

    public StatusUserPage clickSaveButton() {
        saveButton.click();

        return this;
    }

    public String getDescription() {

        return descriptionText.getText();
    }

    public String getDescriptionText() {

        return addDescriptionInput.getText();
    }

    public UserConfigPage clickConfigureSideMenu() {
        getWait5().until(ExpectedConditions.elementToBeClickable(
                getDriver().findElement(By.cssSelector("[href$='/configure']")))).click();

        return new UserConfigPage(new StatusUserPage(getDriver()));
    }
}
