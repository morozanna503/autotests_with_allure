package model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.base.BaseMainHeaderPage;
import model.base.BasePage;

public class ChangesPage<JobTypePage extends BasePage<?, ?>> extends BaseMainHeaderPage<ChangesPage<JobTypePage>> {

    @FindBy(xpath = "//div[@id='main-panel']")
    private WebElement mainPanel;

    private final JobTypePage jobTypePage;

    public ChangesPage(JobTypePage jobTypePage) {
        super(jobTypePage.getDriver());
        this.jobTypePage = jobTypePage;
    }

    public String getTextOfPage() {
        return getWait5().until(ExpectedConditions.visibilityOf(mainPanel)).getText();
    }
}
