import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class UltimateQATest {

    // typy proste i typy obiektowe
    String projectLocation = System.getProperty("user.dir");
    //zmienne lokalne / zmienne globalne - scope
    ChromeDriver driver;

    //SetProperty do BeforeAll
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", projectLocation + "/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
    }

    // hermetyzacja (in. enkapsulacja w java)
    // void - zwracanie wartosci przez funkcji
    @Test
    public void testOne() {
        WebElement button = driver.findElementById("idExample");
        button.click();

        // assertions
        WebElement text = driver.findElementByClassName("entry-title");
        //     //*[@class='...'] - ogolna postac xpath
        //     //*[@class='...' and @id='...']//*[@id='']
        //     //*[contains(@class, '...')]
        //     //*[contains(@class, 'et_pb_module et_pb_cta_0 et_pb_promo')]
        //     //div[@class='navbar-header']//img[@alt='Nasa']
        //     //*[text()='MORE STORIES']
        //     / - jeden poziom nizej
        //     // - dwa lub wiecej poziomow nizej
        //  WebElement textUsingXpath = driver.findElementByXPath("//*[@class='entry-title']");
        Assertions.assertEquals("Button success", text.getText());
    }


    @AfterEach
    public void teardown() {
        // roznica driver.quit() a driver.close()
        driver.quit();
    }

    @Test
    public void testTwo() {
        WebElement nameInput = driver.findElementByName("et_pb_contact_name_0");
        nameInput.sendKeys("Tester");

        WebElement emailInput = driver.findElementByName("et_pb_contact_email_0");
        emailInput.sendKeys("tester@tester.pl");

        // czas oczekiwan w Selenium
        // implicit wait / explicit wait / fluent wait / Thread.sleep
    }

    @Test
    public void testThree() {
        WebElement blueField = driver.findElementByXPath("//*[contains(@class, 'et_pb_module et_pb_cta_0 et_pb_promo')]");
        // zmiana koloru HEX na RGBA
        Assertions.assertEquals("rgba(46, 163, 242, 1)", blueField.getCssValue("background-color"));
    }

}
