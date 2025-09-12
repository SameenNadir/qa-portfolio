package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DarazCartTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.daraz.pk/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // ✅ 1) Wait until Cart icon is present and visible
            WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("a[href*='/cart']")));

            // ✅ 2) Scroll to the element in case it’s hidden
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartIcon);

            // ✅ 3) Try normal click
            try {
                wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
                System.out.println("✅ Clicked Cart normally.");
            } catch (Exception e) {
                // ✅ 4) If normal click fails, force click using JavaScript
                System.out.println("⚠️ Normal click failed, using JS click.");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartIcon);
            }

            // ✅ 5) Verify Cart page opened
            wait.until(ExpectedConditions.titleContains("Cart"));
            System.out.println("✅ Cart page opened successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
