package model.jobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import model.*;
import model.base.BaseProjectPage;
import model.jobsconfig.PipelineConfigPage;

public class PipelinePage extends BaseProjectPage<PipelinePage> {

    @FindBy(css = ".stage-header-name-0")
    private WebElement stage;

    public PipelinePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PipelineConfigPage clickConfigure() {
        setupClickConfigure();
        return new PipelineConfigPage(this);
    }

    public String getStage() {
        return stage.getText();
    }
}
