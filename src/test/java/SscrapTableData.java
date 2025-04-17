import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SscrapTableData {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void ScrapData() {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");
        WebElement Table = driver.findElement(By.className("floatThead-wrapper"));
        List<WebElement> Rows = Table.findElements(By.cssSelector("tr"));
        int i = 0;
        for (WebElement row : Rows) {
            List<WebElement> Cells = row.findElements(By.cssSelector("td"));
            for (WebElement cell : Cells) {
                i++;
                System.out.println("num [" + i + " ]" + cell.getText());
            }
        }
    }

    @AfterAll
    public void TearDown() {
        driver.quit();
    }
}
