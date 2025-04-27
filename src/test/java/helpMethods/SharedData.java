package helpMethods;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {

    public WebDriver driver;
    public String testName;

    @BeforeMethod
    public void prepareEnvironment() {
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        testName = this.getClass().getSimpleName();
        LoggerUtility.startTest(testName);
    }

    @AfterMethod
    public void clearEnvironment() {
        driver.quit();
        LoggerUtility.finishTest(testName);
    }
}
