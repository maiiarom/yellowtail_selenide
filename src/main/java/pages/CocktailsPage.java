package pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.page;

public class CocktailsPage {

    @FindBy(css = ".selected")
    private SelenideElement selectCocktailsDropBox;
    @FindBy(css = "[data-value=\"red\"]")
    private SelenideElement redWineCocktailItem;
    @FindBy(css = "[data-value=\"bubbles\"]")
    private SelenideElement sparklingWineCocktailItem;
    @FindBy(css = ".selected>span")
    private SelenideElement cocktailsTypeField;
    @FindBy(css = "[href=\"raspberry-rose\"]")
    private SelenideElement raspberryRoseWine;
    @FindBy(xpath = "//div[@class=\"tile recipe-tile\"]")
    private ElementsCollection searchResults;

    public void selectCocktailsDropBoxClick() {
        selectCocktailsDropBox.click();
    }

    public void redWineCocktailItemClick() {
        redWineCocktailItem.click();
    }

    public void raspberryRoseWineClick() {
        raspberryRoseWine.click();
    }

    public void sparklingWineCocktailItemClick() {
        sparklingWineCocktailItem.click();
    }

    public CocktailDetailsPage navigateToCocktailDetailsPage(){
        return page(CocktailDetailsPage.class);
    }

    public void scrolling(SelenideElement element) {
        element.scrollTo();
    }

    public SelenideElement getSelectCocktailsDropBox() {
        return selectCocktailsDropBox;
    }

    public SelenideElement getRedWineCocktailItem() {
        return redWineCocktailItem;
    }

    public SelenideElement getSparklingWineCocktailItem() {
        return sparklingWineCocktailItem;
    }

    public SelenideElement getRaspberryRoseWine() {
        return raspberryRoseWine;
    }

    public ElementsCollection getSearchResults() {
        return searchResults;
    }

    public SelenideElement getCocktailsTypeField() { return cocktailsTypeField; }
}
