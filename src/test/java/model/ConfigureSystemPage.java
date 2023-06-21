package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import model.base.BaseMainHeaderPage;

public class ConfigureSystemPage extends BaseMainHeaderPage<ConfigureSystemPage> {

    @FindBy(xpath = "//h1")
    private WebElement title;

    public ConfigureSystemPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {

        return title.getText();
    }
}
