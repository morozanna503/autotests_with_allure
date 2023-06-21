package model.jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.base.BaseProjectPage;
import model.jobsconfig.MultiConfigurationProjectConfigPage;

public class MultiConfigurationProjectPage extends BaseProjectPage<MultiConfigurationProjectPage> {

    public MultiConfigurationProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MultiConfigurationProjectConfigPage clickConfigure() {
        setupClickConfigure();
        return new MultiConfigurationProjectConfigPage(this);
    }

    public String getJobBuildStatus() {
        WebElement buildStatus = getWait5().until(ExpectedConditions.visibilityOf(getDriver()
                .findElement(By.xpath("//div[@id='matrix']//span[@class='build-status-icon__outer']/child::*"))));
        new Actions(getDriver()).moveToElement(buildStatus).perform();
        return buildStatus.getAttribute("tooltip");
    }

}

