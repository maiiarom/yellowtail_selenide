import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

public class SelenideRunner {

    @BeforeEach
    void before() {
        Selenide.clearBrowserCookies();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
