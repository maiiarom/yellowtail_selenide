package pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class WhereToBuyPage {

    @FindBy(css = "#locationName")
    private SelenideElement fieldLocation;
    @FindBy(css = ".search-submit")
    private SelenideElement searchButton;
    @FindBy(css = "div.address")
    private ElementsCollection searchResults;

    public void fieldLocationClick() {
        fieldLocation.click();
    }

    public void searchButtonClick() {
        searchButton.click();
    }

//    public String searchResultsGetText(SelenideElement element){
//        return element.getText();
//    }

    public SelenideElement getFieldLocation() { return fieldLocation; }

    public ElementsCollection getSearchResults(String searchString) {
        fieldLocationClick();
        getFieldLocation().setValue(searchString);
        searchButtonClick();
        return searchResults;
    }
}
