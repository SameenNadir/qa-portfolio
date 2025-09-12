package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class SimpleDarazTest {
    public static void main(String[] args) {
        System.out.println("🚀 Starting SimpleDarazTest...");

        // Set up ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            System.out.println("🌐 Navigating to https://www.daraz.pk/ ...");
            driver.get("https://www.daraz.pk/");
            driver.manage().window().maximize();

            System.out.println("⏳ Waiting for page title to contain 'Daraz' ...");
            wait.until(ExpectedConditions.titleContains("Daraz"));

            String title = driver.getTitle();
            String url = driver.getCurrentUrl();
            System.out.println("✅ Page loaded.");
            System.out.println("Title: " + title);
            System.out.println("URL:   " + url);

            // Print cookie count and names (non-intrusive)
            Set<org.openqa.selenium.Cookie> cookies = driver.manage().getCookies();
            System.out.println("Cookies present: " + cookies.size());
            if (!cookies.isEmpty()) {
                cookies.forEach(c -> System.out.println(" - " + c.getName() + " = " + c.getValue()));
            }

            // As an extra, show whether <body> exists (simple DOM check)
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
            System.out.println("DOM body element is present.");

            System.out.println("🎉 Simple test finished successfully.");

        } catch (Exception e) {
            System.out.println("❌ Test failed with exception:");
            e.printStackTrace();
        } finally {
            System.out.println("🛑 Closing browser.");
            driver.quit();
        }
    }
}
