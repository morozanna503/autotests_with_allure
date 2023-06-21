package model.jobs;

import org.openqa.selenium.WebDriver;
import model.base.BaseOtherFoldersPage;
import model.jobsconfig.MultibranchPipelineConfigPage;

public class MultibranchPipelinePage extends BaseOtherFoldersPage<MultibranchPipelinePage> {

    public MultibranchPipelinePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MultibranchPipelineConfigPage clickConfigure() {
        setupClickConfigure();
        return new MultibranchPipelineConfigPage(new MultibranchPipelinePage(getDriver()));
    }
}
