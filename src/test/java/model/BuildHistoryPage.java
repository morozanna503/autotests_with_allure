package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import model.base.BaseMainHeaderPage;

public class BuildHistoryPage extends BaseMainHeaderPage<BuildHistoryPage> {

    @FindBy(xpath = "//table[@id='projectStatus']/tbody/tr/td[4]")
    private WebElement statusMessage;

    @FindBy(xpath = "//a[@class='jenkins-table__link jenkins-table__badge model-link inside']")
    private WebElement nameOfBuildLink;

    public BuildHistoryPage(WebDriver driver) {
        super(driver);
    }

    public BuildPage clickPipelineProjectBuildNumber(String projectName) {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/job/" + projectName + "/1/']")))
                .click();

        return new BuildPage(getDriver());
    }

    public ConsoleOutputPage clickProjectBuildConsole(String projectBuildName) {
        getDriver().findElement(By.xpath("//a[contains(@href, '" + projectBuildName + "')  and contains(@href, 'console') and not(contains(@href, 'default'))]")).click();

        return new ConsoleOutputPage(getDriver());
    }

    public String getStatusMessageText() {
        getDriver().navigate().refresh();

        return statusMessage.getText();
    }

    public BuildHistoryPage clickBuildNameOnTimeline(String projectBuildName) {
        getDriver().findElement(By.xpath("//div[contains(text(), '" + projectBuildName + "')]")).click();

        return this;
    }

    public String getBubbleTitleOnTimeline() {
        getWait5().until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='simileAjax-bubble-contentContainer simileAjax-bubble-contentContainer-pngTranslucent']")));

        return getDriver().findElement(By.xpath("//div[@class='timeline-event-bubble-title']/a")).getText();
    }

    public int getNumberOfLinesInBuildHistoryTable() {
        getWait5().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1")));

        return getDriver().findElements(By.xpath("//table[@id='projectStatus']/tbody/tr")).size();
    }

    public BuildPage clickNameOfBuildLink() {
        getWait10().until(ExpectedConditions.elementToBeClickable(nameOfBuildLink)).click();

        return new BuildPage(getDriver());
    }

    public NewJobPage clickNewItem() {
        getDriver().findElement(By.cssSelector(".task-link-wrapper>a[href$='newJob']")).click();

        return new NewJobPage(getDriver());
    }
}
