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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NegativeTest {
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSignInInvalid() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.xpath("//div[@id='my-header']/header/div[2]")).click();
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("${firstname}");
        driver.findElement(By.id("lastname")).click();
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys("${lastname}");
        driver.findElement(By.id("telephone")).click();
        driver.findElement(By.id("telephone")).clear();
        driver.findElement(By.id("telephone")).sendKeys("${phone}");
        driver.findElement(By.id("new-username")).click();
        driver.findElement(By.id("new-username")).clear();
        driver.findElement(By.id("new-username")).sendKeys("${login}");
        driver.findElement(By.id("new-password")).click();
        driver.findElement(By.id("new-password")).clear();
        driver.findElement(By.id("new-password")).sendKeys("${password}");
        driver.findElement(By.id("confirm-password")).click();
        driver.findElement(By.id("confirm-password")).clear();
        driver.findElement(By.id("confirm-password")).sendKeys("${password}");
        driver.findElement(By.id("btnSignUp")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.findElement(By.xpath("//p")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        // Warning: verifyTextNotPresent may require manual changes
        try {
            assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*You can sign in\\.[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testLogInInvalid() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.xpath("//div[@id='my-header']/header/div[2]")).click();
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("test");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1111");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            assertEquals("Incorrect login or password!", driver.findElement(By.xpath("//div[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Log In")).click();
    }

    @Test
    public void testAddCarInvalid() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.xpath("//div[@id='my-header']/header/div[2]")).click();
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.id("btn-add")).click();
        driver.findElement(By.xpath("//div[@id='my-content']/div/div/div[3]/div/dl/dt/span")).click();
        driver.findElement(By.linkText("Audi")).click();
        driver.findElement(By.xpath("//div[@id='my-content']/div/div/div[4]/div/dl/dt")).click();
        driver.findElement(By.linkText("A4")).click();
        driver.findElement(By.xpath("//div[@id='my-content']/div/div/div[5]/div/dl/dt/span")).click();
        driver.findElement(By.linkText("4x4")).click();
        driver.findElement(By.xpath("//div[@id='my-content']/div/div/div[6]/div/dl/dt/span")).click();
        driver.findElement(By.linkText("automatic")).click();
        driver.findElement(By.xpath("//div[@id='my-content']/div/div/div[7]/div/dl/dt/span")).click();
        driver.findElement(By.linkText("petrol")).click();
        driver.findElement(By.xpath("//div[@id='my-content']/div/div/div[8]/div/dl/dt/span")).click();
        driver.findElement(By.linkText("Beige")).click();
        driver.findElement(By.id("price")).click();
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("price")).sendKeys("${price}");
        driver.findElement(By.id("mileage")).click();
        driver.findElement(By.id("mileage")).clear();
        driver.findElement(By.id("mileage")).sendKeys("${mileage}");
        driver.findElement(By.id("year")).click();
        driver.findElement(By.id("year")).clear();
        driver.findElement(By.id("year")).sendKeys("${year}");
        driver.findElement(By.id("engine")).click();
        driver.findElement(By.id("engine")).clear();
        driver.findElement(By.id("engine")).sendKeys("${engine}");
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys("${description}");
        driver.findElement(By.id("add")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.findElement(By.xpath("//p")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
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
