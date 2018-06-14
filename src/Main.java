
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.booking.com/");

        WebElement destination = driver.findElement(By.id("ss"));
        destination.sendKeys("Belgrade, Central Serbia, Serbia");

        
        //CHECK IN
        WebElement checkIn = driver.findElement(By.className("xp__dates__checkin"));
        checkIn.click();
        
        WebElement pickCheckInDate = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/div/div[1]/table/tbody/tr[3]/td[5]"));
        pickCheckInDate.click();
        
        

        //CHECK OUT
        WebElement checkOut = driver.findElement(By.className("xp__dates__checkout"));
        checkOut.click();
        
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement checkOutDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div[3]/div/div/div[1]/table/tbody/tr[5]/td[6]")));
        checkOutDate.click();
        
        

        //GUESTS
        WebElement guests = driver.findElement(By.className("xp__guests"));
        guests.click();
        
        Select roomsNumber = new Select(driver.findElement(By.id("no_rooms")));
        roomsNumber.selectByValue("4");
        
        Select adultsNumber = new Select(driver.findElement(By.id("group_adults")));
        adultsNumber.selectByValue("8");
        
        Select childrenNumber = new Select(driver.findElement(By.id("group_children")));
        childrenNumber.selectByValue("2");
        
//        Select childrenAgeCheck1 = new Select(driver.findElement(By.name("age")));
//        childrenAgeCheck1.selectByValue("12");

        Select childrenAgeCheck1 = new Select(driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/div[4]/select[1]")));
        childrenAgeCheck1.selectByValue("12");
        
        Select childrenAgeCheck2 = new Select(driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/div[4]/select[2]")));
        childrenAgeCheck2.selectByValue("12");
        
        
        //SEARCH
//        WebElement searchButton = driver.findElement(By.className("sb-searchbox__button"));
//        searchButton.click();

        WebDriverWait waitSearch = new WebDriverWait(driver, 5);
        WebElement clickSearch = waitSearch.until(ExpectedConditions.elementToBeClickable(By.className("sb-searchbox__button")));
        clickSearch.click();
        

        
        Thread.sleep(5000);
        driver.quit();
    }

}
