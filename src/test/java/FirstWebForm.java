import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstWebForm {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void FillUpForm() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Accept cookies
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".accept-btn-container button"))).click();

        //Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        // Fill in name and phone number
        List<WebElement> textboxes = driver.findElements(By.className("form-control"));
        textboxes.get(0).sendKeys("John Dev");
        textboxes.get(1).sendKeys("0158352215");

        // date field
        WebElement dateField = textboxes.get(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", dateField);
        Thread.sleep(1000); 
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateField);
        dateField.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        dateField.sendKeys("04/15/2025");
        dateField.sendKeys(Keys.ENTER);

        // Email and About
        textboxes.get(3).sendKeys("demoqa@gmail.com");
        textboxes.get(4).sendKeys("I am John Dev");

        //Scroll down
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,400)");

        WebElement uploadElement = driver.findElement(By.id("edit-uploadocument-upload"));
        uploadElement.sendKeys("D:\\Bug Report.xlsx");
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement checkbox = wait3.until(ExpectedConditions.presenceOfElementLocated(By.name("age")));

// Scroll into view before clicking
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", checkbox);
        Thread.sleep(500);

        try {
            wait3.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        }
        Thread.sleep(500);
        WebElement submitButton = driver.findElement(By.id("edit-submit"));
        submitButton.click();

        WebElement confirmation = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

        String message = confirmation.getText().trim();
        Assertions.assertEquals("Thank you for your submission!", message);

    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}

