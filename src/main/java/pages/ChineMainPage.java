package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.webdriverContainer;

public class ChineMainPage {

    @FindBy (css = ".heading-editable>font:first-child")
    private WebElement chinaMainPageWelcomeLabel;
    @FindBy (css = ".sgg-comp-social-icon>.fa.fa-weibo")
    private SelenideElement weiboIcon;

    public void weiboIconClick() {
        weiboIcon.click();
    }

    public WeiboChinaPage navigateToWeiboChinaPage() {
        weiboIconClick();
        switchTo().window(1);
        return page(WeiboChinaPage.class);
    }

    public String getPageUrl(){
        return webdriverContainer.getCurrentFrameUrl();
    }

    public SelenideElement getWeiboIcon() {
        return weiboIcon;
    }
}

