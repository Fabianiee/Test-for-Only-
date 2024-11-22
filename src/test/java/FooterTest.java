import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class FooterTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Mary\\QA_Education\\QA-java-diplom-1\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            driver.get("https://only.digital");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("footer")));

            FooterPage footerPage = new FooterPage(driver);

            if (footerPage.getFooter() != null) {
                System.out.println("Футер найден");

                String[] footerTexts = footerPage.getFooterElementsText();
                for (String text : footerTexts) {
                    System.out.println("Элемент найден: " + text);
                }
            } else {
                System.out.println("Футер не найден");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

