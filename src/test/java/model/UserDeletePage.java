package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import model.base.BaseMainHeaderPage;
import runner.*;
import runner.order.TestUtils;

public class UserDeletePage extends BaseMainHeaderPage<UserDeletePage> {

    public UserDeletePage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickOnYesButton() {
        TestUtils.click(this, getDriver().findElement(By.name("Submit")));

        return new MainPage(getDriver());
    }
}
