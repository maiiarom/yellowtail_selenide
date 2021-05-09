package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.WebDriverRunner.webdriverContainer;

public class CocktailDetailsPage {

    @FindBy (css = ".row>h3")
    private SelenideElement ingredientSection;

    public CocktailDetailsPage() {
        super();
    }

    public String getPageUrl(){
        return webdriverContainer.getCurrentFrameUrl();
    }

    public SelenideElement getIngredientSection() {
        return ingredientSection;
    }
}
