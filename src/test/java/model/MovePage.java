package model;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import model.base.BaseMainHeaderPage;
import model.base.BasePage;

public class MovePage<JobTypePage extends BasePage<?, ?>> extends BaseMainHeaderPage<MovePage<JobTypePage>> {

    private final JobTypePage jobTypePage;

    public MovePage(JobTypePage jobTypePage) {
        super(jobTypePage.getDriver());
        this.jobTypePage = jobTypePage;
    }

    public MovePage<JobTypePage> selectDestinationFolder(String folderName) {
        new Select(getWait5().until(ExpectedConditions.elementToBeClickable(By.name("destination")))).selectByValue("/" + folderName);
        return this;
    }

    public JobTypePage clickMoveButton() {
        getDriver().findElement(By.name("Submit")).click();
        return jobTypePage;
    }
}
