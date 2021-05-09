package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.WebDriverRunner.webdriverContainer;

public class WeiboChinaPage {

    @FindBy(css = ".logo")
    private SelenideElement weiboIcon;

    public String getPageUrl(){
        return webdriverContainer.getCurrentFrameUrl();
    }
    }
