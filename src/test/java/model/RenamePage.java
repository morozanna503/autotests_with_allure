package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.base.BaseMainHeaderPage;
import model.base.BasePage;

public class RenamePage<JobTypePage extends BasePage<?, ?>> extends BaseMainHeaderPage<RenamePage<JobTypePage>> {

    private final JobTypePage jobTypePage;

    public RenamePage(JobTypePage jobTypePage) {
        super(jobTypePage.getDriver());
        this.jobTypePage = jobTypePage;
    }

    public RenamePage<JobTypePage> enterNewName(String name) {
        WebElement inputTextbox = getDriver().findElement(By.name("newName"));
        inputTextbox.clear();
        inputTextbox.sendKeys(name);
        return this;
    }

    public JobTypePage clickRenameButton() {
        getDriver().findElement(By.name("Submit")).click();
        return jobTypePage;
    }

    public String getErrorMessage() {
        getWait5().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(".error")))).click();
        return getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error"))).getText();
    }

    public CreateItemErrorPage clickRenameButtonAndGoError() {
        getDriver().findElement(By.name("Submit")).click();
        return new CreateItemErrorPage(getDriver());
    }
}
