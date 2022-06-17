import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",   "resources/chromedriver.exe");
        String searchTerm = "demo with Selenium";
        //Open browser
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        // input text: Demo with selenium
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchTerm);
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();
        System.out.println("finished click button search ");
        //verify results search pages with text"Demo with selenium"
        List<WebElement> my_list = driver.findElements(By.cssSelector(".g"));
        System.out.println("số kết quả tìm kiếm trong pages: "+ my_list.size());
        for (int i = 0; i < my_list.size(); i++) {
            String check = "text not found";

            boolean n = check.equals(my_list.get(i).getText());
            if (n== true){
                System.out.println("có trùng từ khóa");
            }
            else {
                System.out.println("không trùng từ khóa");
            }

        }
        // close browser
        driver.quit();
    }
}