package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import utill.PropertyReader;

import java.util.List;

import static org.testng.Assert.*;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Check that Google has result for request")
    public void simpleWebTest() throws InterruptedException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        getDriver().get(PropertyReader.getProperties().getProperty("url")); // open Google homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        getPo().getWelement("searchField").sendKeys(PropertyReader.getProperties().getProperty("requestText"));
        getPo().getWelement("searchButton").click();
        List<WebElement> results = getPo().getWelements("results");
        assertTrue(!results.isEmpty());//check that result not empty
    }

}
