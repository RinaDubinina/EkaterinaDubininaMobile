package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import utill.PropertyReader;

import static org.testng.Assert.*;

public class webMobileTests extends BaseTest {

    public static final String REQUEST_TEXT = "EPAM";
    public static final int EXPECTED_RESULT = 10;

    @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
    public void simpleWebTest() throws InterruptedException {
        getDriver().get(PropertyReader.getProperties().getProperty("url")); // open Google homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys(REQUEST_TEXT);
        getDriver().findElement(By.xpath("//button[@class='Tg7LZd']")).click();
        getDriver().findElements(By.cssSelector("div[id='rso']>div")).size(); //results
        assertEquals(getDriver().findElements(By.cssSelector("div[id='rso']>div")).size(), EXPECTED_RESULT, "Google don't find expected amount of results for \"EPAM\" request");
    }

}
