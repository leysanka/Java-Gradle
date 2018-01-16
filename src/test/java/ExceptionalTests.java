import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExceptionalTests {
    private static WebDriver driver;

    @BeforeClass
    public static void startDriver(){
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();
    }

    @Test
    public  void a_throwingException()  {
        System.out.println("Running test 1");
        try {
            throw new NullPointerException("Test exception");
        } catch (Exception e){
            System.out.println("Catched exception.");
        }
        finally {
            System.out.println("Finnaly called.");
        }
    }

    @Test
    public  void noException(){
        System.out.println("Running test 2");
        driver.navigate().to("https://mvnrepository.com");
        System.out.println("Running test 2 finished");
    }

    @AfterClass
    public static void quit(){
        driver.quit();
        System.out.println("Quit done.");
    }
}
