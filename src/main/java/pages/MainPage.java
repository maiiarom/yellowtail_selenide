package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    // page elements
    @FindBy(css=".-one .large-mobile")
    private SelenideElement welcomeLabel;
    @FindBy(css=".fa-bars")
    private SelenideElement menuButton;
    @FindBy(css=".-one>.home-button")
    private SelenideElement findYourWineButton;
    @FindBy(css=".primary-footer")
    private SelenideElement footer;
    @FindBy(css=".-one>h2")
    private SelenideElement welcomeToWorldYellowTailLabel;
    @FindBy(css=".-one>.header-sub-copy")
    private SelenideElement enjoyLabel;

    // menu elements
    @FindBy(css=".top-nav .yt-logo")
    private SelenideElement menuYellowTail;
    @FindBy(css=".main-nav [href*=\"wines\"]")
    private SelenideElement menuWines;
    @FindBy(css=".main-nav [href*=\"stores\"]")
    private SelenideElement menuWhereToBuy;
    @FindBy(css=".main-nav [href*=\"cocktails\"]")
    private SelenideElement menuCocktails;
    @FindBy(css=".main-nav [href*=\"our-story\"]")
    private SelenideElement menuOurStory;
    @FindBy(css=".main-nav [href*=\"faqs\"]")
    private SelenideElement menuFAQS;
    @FindBy(css=".main-nav [href*=\"contact\"]")
    private SelenideElement menuContact;
    @FindBy(css=".country-select span")
    private SelenideElement menuLanguage;
    @FindBy(css="[data-key=\"CN\"]")
    private SelenideElement menuChinaLanguage;

    public void menuButtonClick(){
        menuButton.click();
    }

    public void menuYellowTailClick(){
        menuYellowTail.click();
    }

    public void menuLanguageClick(){
        menuLanguage.click();
    }

    public void menuChinaLanguageClick() { menuChinaLanguage.click(); }

    public void menuWhereToBuyClick() { menuWhereToBuy.click(); }

    public void menuCocktailsClick() { menuCocktails.click(); }

    public ChineMainPage navigateToChineMainPage(){
        menuButtonClick();
        menuLanguageClick();
        menuChinaLanguageClick();
        return page(ChineMainPage.class);
    }

    public WhereToBuyPage navigateToWhereToBuyPage(){
        menuButtonClick();
        menuWhereToBuyClick();
        return page(WhereToBuyPage.class);
    }

    public CocktailsPage navigateToCocktailsPage() {
        menuButtonClick();
        menuCocktailsClick();
        return page(CocktailsPage.class);
    }

    public SelenideElement getWelcomeLabel() {
        return welcomeLabel;
    }

    public SelenideElement getMenuButton() {
        return menuButton;
    }

    public SelenideElement getFindYourWineButton() {
        return findYourWineButton;
    }

    public SelenideElement getFooter() {
        return footer;
    }

    public SelenideElement getWelcomeToWorldYellowTailLabel() {
        return welcomeToWorldYellowTailLabel;
    }

    public SelenideElement getEnjoyLabel() {
        return enjoyLabel;
    }

    public SelenideElement getMenuYellowTail() {
        return menuYellowTail;
    }

    public SelenideElement getMenuWines() {
        return menuWines;
    }

    public SelenideElement getMenuWhereToBuy() {
        return menuWhereToBuy;
    }

    public SelenideElement getMenuCocktails() {
        return menuCocktails;
    }

    public SelenideElement getMenuOurStory() {
        return menuOurStory;
    }

    public SelenideElement getMenuFAQS() {
        return menuFAQS;
    }

    public SelenideElement getMenuContact() {
        return menuContact;
    }

    public SelenideElement getMenuLanguage() {
        return menuLanguage;
    }

    public SelenideElement getChinaLanguage() {
        return menuChinaLanguage;
    }
}
