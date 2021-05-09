import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import pages.*;
import utils.Constants;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.Constants.PATH_TO_FIREFOX_DRIVER;
import static utils.Constants.SYSTEM_PROPERTY_FIREFOX_DRIVE;

public class YellowTailWine extends SelenideRunner {
    @Test
    //Case 1: Welcome page: all required elements are displayed
    //1. Go to Welcome page: https://www.yellowtailwine.com
    //2. Verify that “I am of legal drinking age in” is displayed
    //3. Verify that checkbox before “I am of legal drinking age in” is displayed
    //4. Verify that dropdown with Select is displayed
    //5. Verify that “Welcome” button is displayed and is inactive
    public void verifyWelcomePageElementsDisplayed() {
        WelcomePage welcomePage = open(Constants.WELCOME_PAGE_URL, WelcomePage.class);

        //verify
        welcomePage.getLegalAgeCheck().shouldHave(text("I am of legal drinking age in"));
        welcomePage.getLegalAgeCheck().isDisplayed();
        welcomePage.getRegionDropBox().isDisplayed();
        welcomePage.getWelcomeButton().isDisplayed();
        welcomePage.getWelcomeButton().isEnabled();
    }

    @Test
    //Case 2: Main page: navigate to main page as European customer
    //1. Tick on checkbox
    //2. Select “Europe” from dropbox
    //3. Press “Welcome” button
    //4. Main page should be displayed
    public void verifyMainPageDisplayed() {
        WelcomePage welcomePage = open(Constants.WELCOME_PAGE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        String resultString = "Welcome".toUpperCase();

        //verify
        mainPage.getWelcomeLabel().shouldHave(text(resultString));
    }

    @Test
    //Case 3: Main page: all required elements are displayed
    //1. Navigate to main page
    //2. Verify that the following elements are displayed:
    //   - menu button
    //   - WELCOME TO THE WORLD OF [Yellow tail]
    //   - We are passionate about creating great tasting, quality wines for everyone to enjoy
    //   - find your wine button
    //   - footer
    public void verifyMainPageElementsDisplayed() {
        WelcomePage welcomePage = open(Constants.WELCOME_PAGE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();

        //verify
        mainPage.getWelcomeToWorldYellowTailLabel().isDisplayed();
        mainPage.getEnjoyLabel().isDisplayed();
        mainPage.getMenuButton().isDisplayed();
        mainPage.getFindYourWineButton().isDisplayed();
        mainPage.getFooter().isDisplayed();
    }

    @Test
    //Case 4: Main page: Menu button logic (open header)
    //1. Navigate to main page
    //2. Click on Menu button
    //3. Verify that header with all needed links is appeared
    //4. Click on [yellow tail]
    //5. Verify that Menu button is visible
    public void verifyMenuButtonOpenLogic() {
        WelcomePage welcomePage = open(Constants.WELCOME_PAGE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        mainPage.menuButtonClick();

        //verify
        mainPage.getMenuYellowTail().isDisplayed();
        mainPage.getMenuWines().shouldHave(text("WINES"));
        mainPage.getMenuWhereToBuy().shouldHave(text("WHERE TO BUY"));
        mainPage.getMenuCocktails().shouldHave(text("COCKTAILS"));
        mainPage.getMenuOurStory().shouldHave(text("OUR STORY"));
        mainPage.getMenuFAQS().shouldHave(text("FAQS"));
        mainPage.getMenuContact().shouldHave(text("CONTACT"));
        mainPage.getMenuLanguage().isDisplayed();

        mainPage.menuYellowTailClick();

        //verify
        mainPage.getMenuButton();
    }

    @Test
    //Case 5: Main page: Menu button logic (close header)
    //1. Navigate to main page
    //2. Click on Menu button
    //3. Click on [yellow tail]
    //4. Verify that Menu button is visible
    public void verifyMenuButtonCloseLogic() {
        WelcomePage welcomePage = open(Constants.WELCOME_PAGE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        mainPage.menuButtonClick();

        //verify
        mainPage.getMenuButton().isDisplayed();
    }

    @Test
    //Case 6: Main page: Global Nav logic
    //1. Navigate to main page
    //2. Click on Menu button
    //3. Click on Globe icon
    //4. Select China in popup and click on it
    //5. Verify that language is changed
    public void verifyNavigationToChinaMainPage() {
        WelcomePage welcomePage = open(Constants.WELCOME_PAGE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        ChineMainPage chineMainPage = mainPage.navigateToChineMainPage();

        //verify
        chineMainPage.getPageUrl().contains(".cn");
    }

    @Test
    //Case 7: Main page: Global Nav logic (CHINA - separate site is open)
    //1. Navigate to main page
    //2. Click on Menu button
    //3. Click on Globe icon
    //4. Select China in popup and click on it
    //5. Click on icon (in white square on screenshot)
    //6. Verify that “https://www.weibo.com/yellowtailChina” site is open in new tab
    public void verifyNavigationToWeiboChinaPage() {
        WelcomePage welcomePage = open(Constants.WELCOME_PAGE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        ChineMainPage chineMainPage = mainPage.navigateToChineMainPage();
        WeiboChinaPage weiboChinaPage = chineMainPage.navigateToWeiboChinaPage();

        //verify
        weiboChinaPage.getPageUrl().contains("weibo.com/yellowtailChina");
    }

    @Test
    //Case 8: Where to buy: enter valid postal code
    //1. Navigate to “Where to buy” page
    //2. Enter valid data in “Your location” field
    //3. Click on Search button
    //4. Verify that the results of search are displayed
    public void verifyValidPostalCodeForWhereToBuyPage() {
        WelcomePage welcomePage = open(Constants.WELCOME_PAGE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        WhereToBuyPage whereToBuyPage = mainPage.navigateToWhereToBuyPage();

        //verify
        String searchString = "Sydney NSW";
        ElementsCollection searchResults = whereToBuyPage.getSearchResults(searchString);
        for (SelenideElement item: searchResults){
            item.shouldHave(text(searchString));
        }
    }

    @Test
    //Case 9: Cocktails: Select one wine
    //1. Navigate to “Cocktails” page
    //2. Select “Red wine cocktails”
    //3. Verify that 7 recipes are displayed
    public void verifyRedWineCocktailsList() {
        WelcomePage welcomePage = open(Constants.WELCOME_PAGE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        CocktailsPage cocktailsPage = mainPage.navigateToCocktailsPage();
        cocktailsPage.selectCocktailsDropBoxClick();
        cocktailsPage.redWineCocktailItemClick();

        //verify
        int searchResult = 7;
        cocktailsPage.getSearchResults().shouldHave(size(searchResult));
    }

    @Test
    //Case 10: Cocktails: Navigate to Cocktail recipe page
    //1. Navigate to “Cocktails” page
    //2. Scroll to “RASPBERRY ROSÉ” recipe
    //3. Click on “RASPBERRY ROSÉ” recipe
    //4. Verify that new page is displayed:
    //- ingredients section is displayed
    public void verifyCocktailsDetailsPage() {
        WelcomePage welcomePage = open(Constants.WELCOME_PAGE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        CocktailsPage cocktailsPage = mainPage.navigateToCocktailsPage();
        cocktailsPage.scrolling(cocktailsPage.getRaspberryRoseWine());
        cocktailsPage.raspberryRoseWineClick();
        CocktailDetailsPage cocktailDetailsPage = cocktailsPage.navigateToCocktailDetailsPage();

        //verify
        cocktailDetailsPage.getPageUrl().contains("recipe/raspberry-rose");
        cocktailDetailsPage.getIngredientSection().isDisplayed();
    }

    @Test
    //Case 11: Cocktails: Select several wines
    //1. Navigate to “Cocktails” page
    //2. Select “Red wine cocktails”
    //3. Select “Sparkling wine cocktails”
    //4. Verify that “Multiple” word is displayed in “Type” dropdown
    //5. Verify that 18 recipes are displayed
    public void verifySparklingWineCocktailsList() {
        WelcomePage welcomePage = open(Constants.WELCOME_PAGE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        CocktailsPage cocktailsPage = mainPage.navigateToCocktailsPage();
        cocktailsPage.selectCocktailsDropBoxClick();
        cocktailsPage.redWineCocktailItemClick();
        cocktailsPage.sparklingWineCocktailItemClick();

        //verify
        int searchResult = 18;
        cocktailsPage.getCocktailsTypeField().shouldHave(text("Multiple"));
        cocktailsPage.getSearchResults().shouldHave(size(searchResult));
    }
}
