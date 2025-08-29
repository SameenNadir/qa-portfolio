import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DarazAutomation {
    public static void main(String[] args) {
        // 1) Set path to ChromeDriver (update for your machine)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\#FZHZI\\IdeaProjects\\test1\\chromedriver.exe");

        // 2) Launch Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // 3) Open Daraz
            driver.get("https://www.daraz.pk/");
            driver.manage().window().maximize();

            // 4) Click 'Login' (may vary by site version/region)
            // Tip: Update locators if UI changes
            WebElement loginButton = driver.findElement(By.linkText("Login"));
            loginButton.click();

            // 5) Enter credentials (use test creds; avoid committing real ones)
            WebElement emailField = driver.findElement(By.name("loginKey"));
            emailField.sendKeys("your_email_or_phone");

            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("your_password");

            // 6) Submit
            WebElement submitButton = driver.findElement(By.cssSelector("button.next-btn-primary"));
            submitButton.click();

            // 7) Basic wait (replace with WebDriverWait later)
            Thread.sleep(5000);

            // 8) Search for "Laptop"
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Laptop");
            searchBox.submit();

            Thread.sleep(3000);
            if (driver.getTitle().toLowerCase().contains("laptop")) {
                System.out.println("✅ Search successful, results loaded.");
            } else {
                System.out.println("❌ Search failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 9) Close
            driver.quit();
        }
    }
}