package env;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.FileUtil;

public class WebDriverManager {

    private static WebDriver driver;

    public static void initWebDriver() {
        if (driver == null) {
//            System.setProperty("webdriver.chrome.driver", "D:\\Projetos\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", FileUtil.getFilePath("webdriver/chromedriver.exe"));
            driver = new ChromeDriver();
        }
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void maximize() {
        driver.manage().window().maximize();
    }

    public static void close() {
        driver.quit();
    }
}
