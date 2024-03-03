import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Form {
        WebDriver driver;
        @BeforeAll
        public void setup(){
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        }
    @Test
    public void writeSomething () throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        //Closing cookies
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("edit-name")).sendKeys("Lita Mouri Sarker");
        driver.findElement(By.id("edit-number")).sendKeys("018994844849");
        Thread.sleep(500);
        driver.findElements(By.tagName("label")).get(2).submit();

    }
    @Test
    public void handleCalendar() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        Utils.scroll(driver,0,500);
        driver.findElement(By.className("form-date"));
        Thread.sleep(1000);
        Actions action=new Actions(driver);
        action.doubleClick().sendKeys("03").sendKeys("03").sendKeys("2024");
        Thread.sleep(1000);

    }
    @Test
    public void fillUp() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        Utils.scroll(driver,0,500);
        Thread.sleep(1000);
        driver.findElement(By.id("edit-email")).sendKeys("lita@test.com");
        Thread.sleep(1000);
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("I am a SQA Engineer");


    }
    @Test
    public void upload () throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        Utils.scroll(driver,0,800);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("[type='file']")).sendKeys("/Users/litamourisarker/Desktop/Java/Webform/src/test/resources/img.jpg");
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("[type='checkbox']")).submit();
        Thread.sleep(500);
        WebElement submit= driver.findElement(By.id("edit-submit"));
        submit.submit();
        String expectedText= "Thank you for your submission!";
        Assertions.assertEquals(expectedText,"Thank you for your submission!");


    }

    @AfterAll
    public void closedriver (){
            driver.quit();
    }
}