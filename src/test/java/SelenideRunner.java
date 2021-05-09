import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.BeforeSuite;

public class SelenideRunner {

    @BeforeEach
    void before() {
        Selenide.clearBrowserCookies();
    }

    @BeforeSuite
    void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
