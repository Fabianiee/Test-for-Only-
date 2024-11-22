import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class FooterPage {
    private WebDriver driver;

    public FooterPage (WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getFooter() {
        return driver.findElement(By.tagName("footer"));
    }

       public boolean isElementInFooter(String elementSelector) {
        WebElement footer = getFooter();
        return footer.findElements(By.cssSelector(elementSelector)).size() > 0;
    }

        public String[] getFooterElementsText() {
        WebElement footer = getFooter();
        return footer.findElements(By.cssSelector("a, p, span"))
                .stream()
                .map(WebElement::getText)
                .toArray(String[]::new);
    }
}
