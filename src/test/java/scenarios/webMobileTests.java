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

    public static final String REQUEST_TEXT = "EPAM";
    public static final int EXPECTED_RESULT = 7;

    @Test(groups = {"web"}, description = "Check that Google has result for request")
    public void simpleWebTest() throws InterruptedException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        getDriver().get(PropertyReader.getProperties().getProperty("url")); // open Google homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        getPo().getWelement("searchField").sendKeys(REQUEST_TEXT);
        getPo().getWelement("searchButton").click();
        List<WebElement> actualResults = getPo().getWelements("results");
        int actualAmountResults = actualResults.size(); //results
        assertTrue(!actualResults.isEmpty());//check that result not empty
        assertEquals(actualAmountResults, EXPECTED_RESULT, "Google don't find expected amount of results for \"EPAM\" request");//check amount results
    }

}
