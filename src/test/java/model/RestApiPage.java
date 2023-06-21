package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.base.BaseMainHeaderPage;

public class RestApiPage extends BaseMainHeaderPage<RestApiPage> {

    public RestApiPage(WebDriver driver) {
        super(driver);
    }

    public String getRestApiPageTitle(){
       return getWait2().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1"))).getText();
    }
}
