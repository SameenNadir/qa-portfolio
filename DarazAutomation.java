package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DarazAutomation {
    public static void main(String[] args) {
        // Auto-setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.daraz.pk/");
            driver.manage().window().maximize();

            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Laptop");
            searchBox.submit();

            Thread.sleep(3000);

            if (driver.getTitle().toLowerCase().contains("laptop")) {
                System.out.println("✅ Search successful");
            } else {
                System.out.println("❌ Search failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
