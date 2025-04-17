import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SecondWebForm {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @DisplayName("Fill up form")
    @Test
    public void FillUpForm() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");

        //Scroll Down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        //FirstName,LastName,PhoneNumber
        List<WebElement> textInputs = driver.findElements(By.cssSelector("input[type='text']"));
        textInputs.get(0).sendKeys("Afsana");
        textInputs.get(1).sendKeys("Kashpia");
        textInputs.get(4).sendKeys("0192398748");

        //Email,Password,Gender,Nationality
        //Rename email before running
        driver.findElement(By.id("user_email")).sendKeys("Afsana1101@gmail.com");
        driver.findElement(By.id("user_pass")).sendKeys("Afs!@#ana@11234");
        driver.findElement(By.id("radio_1665627729_Female")).click();
        driver.findElement(By.id("input_box_1665629217")).sendKeys("Bangladeshi");

        //country
        Select country = new Select(driver.findElement(By.id("country_1665629257")));
        country.selectByVisibleText("Bangladesh");

        //Date of Birth
        WebElement date = textInputs.get(2);
        date.click();

        Thread.sleep(1000);

        WebElement dateToHover = driver.findElement(By.xpath("//span[contains(@class, 'flatpickr-day') and text()='16']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dateToHover).click().perform();

        Thread.sleep(2000);

        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // terms and condition
        driver.findElement(By.id("privacy_policy_1665633140")).click();

        // submit button
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Assert that registration is successful
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ur-submit-message-node")));
        Assertions.assertTrue(successMessage.getText().contains("User successfully registered."));

    }

    @AfterAll
    public void TearDown() {
        driver.quit();
    }
}



