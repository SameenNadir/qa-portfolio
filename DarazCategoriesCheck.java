package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DarazCategoriesCheck {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.daraz.pk/");
        driver.manage().window().maximize();

        // Step 1: Find categories
        List<WebElement> categories = driver.findElements(By.cssSelector(".lzd-site-menu-root>ul>li"));
        System.out.println("Found " + categories.size() + " categories");

        for (WebElement cat : categories) {
            System.out.println(cat.getText());
        }

        driver.quit();
    }
}
