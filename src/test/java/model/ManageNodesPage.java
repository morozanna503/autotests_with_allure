package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.base.BaseMainHeaderPage;

import java.util.List;

public class ManageNodesPage extends BaseMainHeaderPage<ManageNodesPage> {

    public ManageNodesPage(WebDriver driver) {
        super(driver);
    }

    public NewNodePage clickNewNodeButton() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='new']"))).click();
        return new NewNodePage(getDriver());
    }

    public String getNodeName(String nodeName) {
        return getWait2().until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//tr[@id='node_" + nodeName + "']/td/a")))
                .getText();
    }

    public NodePage clickOnNode(String nodeName) {
        List<WebElement> nodes = getDriver().findElements(By.xpath("//a[@class='jenkins-table__link model-link inside']"));
        for (WebElement ele : nodes) {
            if (ele.getText().equals(nodeName)) {
                new Actions(getDriver()).moveToElement(ele).click().perform();
                break;
                //return new NodePage(getDriver());
            }
        }
       return new NodePage(getDriver());
    }
}

