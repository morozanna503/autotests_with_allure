package model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import model.base.BaseMainHeaderPage;
import model.base.BasePage;

public class DeletePage<ParentPage extends BasePage<?,?>> extends BaseMainHeaderPage<DeletePage<ParentPage>> {

    @FindBy(name = "Submit")
    private WebElement deleteYesButton;

    private final ParentPage parentPage;

    public DeletePage(ParentPage parentPage) {
        super(parentPage.getDriver());
        this.parentPage = parentPage;
    }

    public ParentPage clickYesButton() {
        deleteYesButton.click();
        return parentPage;
    }
}
