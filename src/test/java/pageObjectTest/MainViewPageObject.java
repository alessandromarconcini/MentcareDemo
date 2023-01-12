package pageObjectTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainViewPageObject {

    private WebDriver driver;

    @FindBy(id = "MainGrid")
    private WebElement grid;

    @FindBy(xpath = "/html/body/div[1]/flow-container-root-2521314/vaadin-vertical-layout/label")
    private WebElement label;

    public String getLabelText(){ return label.getText();}

    public MainViewPageObject(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
