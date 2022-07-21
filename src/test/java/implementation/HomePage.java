package implementation;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomePage extends PageObject {
    public static String baseurl = "https://www.google.com/";
    private final By acceptCookiesButton = By.xpath("//button[@id='L2AGLb']");
    private final By searchField = By.xpath("//*[@role='combobox']");
    private String siteName ="//*[contains(text(),'%s')]";
    private final By nextButton = By.xpath("//*[@id='pnnext']/span[2]");

    WebDriver driver;

    public HomePage() {
        System.setProperty("webdriver.chrome.driver", "/Users/ingakochiashvili/Downloads/chromedriver");
    }

    public void openPage() {
        driver = new ChromeDriver();
        driver.get(baseurl);
        waitABit(1000);
        driver.findElement(acceptCookiesButton).click();
        waitABit(1000);
    }

    public void quitDriver(){
        driver.quit();
    }

    @Step("submit {text} in search field")
    public void searchForText(String text) {
        WebElement element = driver.findElement(searchField);
        element.click();
        element.sendKeys(text);
        element.sendKeys(Keys.RETURN);
    }

    @Step("find {siteName} among result")
    public void textIsAmongResult(String text) {
        waitABit(1000);
        List<WebElement> list = driver.findElements(By.xpath((String.format(siteName, text))));
        Assert.assertTrue("Hadrian site not found!", list.size() >0);
    }

    @Step("find {string} among first 10 pagess")
    public void siteAmongTenPages(String text){
        List<WebElement> list;
        boolean found = false;
        int pageNumber;
        for ( pageNumber=0;pageNumber<9 && ! found; pageNumber++) {
            // pageNumber <9 because on this step the 1st page is already covered
            waitABit(1000);
            list = driver.findElements(By.xpath((String.format(siteName, text))));
            found = list.size() > 0;
            driver.findElement(nextButton).click();
        }
        Assert.assertTrue("Hadrian site not found!", found);
        System.out.println("Hadrian corporate site is on #" + pageNumber + " page");
    }
}

