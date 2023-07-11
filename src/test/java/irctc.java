import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class irctc {

    @Test
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Chrome Driver\\New\\chromedriver_win32 (1)\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.irctc.co.in/nget/train-search");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement bus = driver.findElement(By.xpath("(//a[@aria-label='Menu BUSES. Website will be opened in new tab'])[1]"));
        bus.click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);

        WebElement dropdownInput = driver.findElement(By.id("departFrom"));
        dropdownInput.sendKeys("Varanasi");
        driver.findElement(By.className("ui-menu-item-wrapper")).click();

        WebElement goingto = driver.findElement(By.id("goingTo"));
        goingto.sendKeys("Delhi");
        driver.findElement(By.xpath("//ul[@id='ui-id-2']//li[1]")).click();

        driver.findElement(By.xpath("//a[normalize-space()='22']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Search Bus']")).click();

        driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Select Seat'])[2]")).click();
        driver.findElement(By.xpath("(//span[@class='Sleeper_V'])[14]")).click();
        driver.findElement(By.xpath("(//span[@class='Sleeper_V'])[20]")).click();

        driver.findElement(By.xpath("//button[normalize-space()='Proceed to Book']")).click();

        driver.findElement(By.id("loginuserid")).sendKeys("pundh9690");
        driver.findElement(By.id("pwd")).sendKeys("Veer9897");

        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Login'])[1]")).click();

        WebElement dropdown = driver.findElement(By.name("state"));
        Select dropdownstate = new Select(dropdown);
        dropdownstate.selectByVisibleText("UTTAR PRADESH");

        driver.findElement(By.xpath("(//input[@placeholder='Traveller Name'])[1]")).sendKeys("Jack");
        WebElement gender = driver.findElement(By.name("select"));
        Select genderdrodown  = new Select(gender);
        genderdrodown.selectByValue("M");
        driver.findElement(By.xpath("(//input[@placeholder='Age'])[1]")).sendKeys("30");


        driver.findElement(By.xpath("(//input[@placeholder='Traveller Name'])[2]")).sendKeys("Rose");
        WebElement gender2 = driver.findElement(By.xpath("(//select[@name='select'])[2]"));
        Select genderdropdown2 = new Select(gender2);
        genderdropdown2.selectByValue("F");
        driver.findElement(By.xpath("(//input[@placeholder='Age'])[2]")).sendKeys("25");

        driver.findElement(By.id("agree")).click();

        driver.findElement(By.xpath("//button[@class='btn btn-md btn-primary btn-radius yellow-gradient']")).click();






    }
}