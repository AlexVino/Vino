package by.vino.mygarage.catalon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PositiveTest {
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testShowCars() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.xpath("//div[@id='my-content']/section/div/div")).click();
        driver.findElement(By.xpath("//div[@id='my-content']/section/div/div/div[2]/div/div/dl/dt/span")).click();
        driver.findElement(By.linkText("Audi")).click();
        driver.findElement(By.xpath("//div[@id='my-content']/section/div/div/div[2]/div[2]/div/dl/dt/span")).click();
        driver.findElement(By.linkText("Q7")).click();
        driver.findElement(By.xpath("//div[@id='my-content']/section/div/div/div[2]/div[3]/div/dl/dt/span")).click();
        driver.findElement(By.linkText("$1")).click();
        driver.findElement(By.xpath("//div[@id='my-content']/section/div[3]/div/div[2]/div/div/dl/dt/span")).click();
        driver.findElement(By.linkText("up to 25 year old")).click();
        driver.findElement(By.xpath("//a[@class='b-search']")).click();
        try {
            assertEquals("Audi Q7", driver.findElement(By.linkText("Audi Q7")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Audi Q7", driver.findElement(By.xpath("//div[@id='result']/div[2]/div/a/p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testShowOrderByAdmin() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.xpath("//div[@id='my-content']/section/div[2]/div/div")).click();
        driver.findElement(By.xpath("//div[@id='my-header']/header/div/div/div/div[3]/a/button")).click();
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.linkText("Orders")).click();
        try {
            assertEquals("First Name", driver.findElement(By.xpath("//section[@id='orders']/div/table/thead/tr/th[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Last Name", driver.findElement(By.xpath("//section[@id='orders']/div/table/thead/tr/th[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Phone number", driver.findElement(By.xpath("//section[@id='orders']/div/table/thead/tr/th[4]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Name", driver.findElement(By.xpath("//section[@id='orders']/div/table/thead/tr/th[5]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Price", driver.findElement(By.xpath("//section[@id='orders']/div/table/thead/tr/th[6]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Complete", driver.findElement(By.id("cancel")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Log Out")).click();
    }

    @Test
    public void testShowCaraUnderUser() throws Exception {
        driver.get("http://localhost:8080/?lang=EN");
        driver.findElement(By.xpath("//div[@id='my-header']/header/div[2]")).click();
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("user");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("11111111");
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.linkText("Search")).click();
        driver.findElement(By.xpath("//img[@alt='no image']")).click();
        try {
            assertEquals("Description", driver.findElement(By.xpath("//div[@id='my-content']/div/div[2]/div[2]/div/section/h3")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Order", driver.findElement(By.id("btn-order")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Log Out")).click();
    }

    @Test
    public void testShowCar() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.xpath("//div[@id='my-header']/header/div[2]")).click();
        driver.findElement(By.linkText("Search")).click();
        driver.findElement(By.xpath("//img[@alt='no image']")).click();
        try {
            assertEquals("Description", driver.findElement(By.xpath("//div[@id='my-content']/div/div[2]/div[2]/div/section/h3")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Order", driver.findElement(By.id("btn-order")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testShowCarUnderUser() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.xpath("//div[@id='my-header']/header/div[2]")).click();
        driver.findElement(By.xpath("//div[@id='my-header']/header/div/div/div/div[3]/a/button")).click();
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("user");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("11111111");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@id='my-content']/section/div/div/div[2]/div/div/dl/dt/span")).click();
        driver.findElement(By.linkText("Audi")).click();
        driver.findElement(By.xpath("//div[@id='my-content']/section/div/div/div[2]/div[2]/div/dl/dt/span")).click();
        driver.findElement(By.linkText("A7")).click();
        driver.findElement(By.linkText("Search")).click();
        try {
            assertEquals("Audi A7", driver.findElement(By.xpath("//div[@id='result']/div/div/a/p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Log Out")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
