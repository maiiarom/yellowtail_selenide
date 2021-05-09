package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import static com.codeborne.selenide.Selenide.page;

public class WelcomePage{

    @FindBy(css = "[for=\"confirm\"]")
    private SelenideElement legalAgeCheck;
    @FindBy(css = "#agegate-selector-options")
    private SelenideElement regionDropBox;
    @FindBy(css = "[type=\"submit\"]")
    private SelenideElement welcomeButton;
    private Select selectElement;

    public WelcomePage() {
        super();
    }

    public void legalAgeCheckClick(){ legalAgeCheck.click(); }

    public void welcomeButtonClick(){ welcomeButton.click(); }

    public void selectValueCountryDropBox(String input){
        selectElement = new Select(regionDropBox);
        selectElement.selectByValue(input);
    }

    public MainPage navigateToMainPage(){
        legalAgeCheckClick();
        selectValueCountryDropBox("eu");
        welcomeButtonClick();
        return page(MainPage.class);
    }

    public SelenideElement getLegalAgeCheck(){ return legalAgeCheck; }

    public SelenideElement getRegionDropBox() { return regionDropBox; }

    public SelenideElement getWelcomeButton() { return welcomeButton; }
}