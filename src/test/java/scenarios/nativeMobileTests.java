package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import utill.PropertyReader;

public class nativeMobileTests extends BaseTest {

    public static final String expectedPageName = "BudgetActivity";

    @Test(groups = {"native"}, description = "This test register new user, log in, cheek the user is logged in")
    public void registerNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        getPo().getWelement("registerButton").click();
        getPo().getWelement("registrationEmail").sendKeys(PropertyReader.getProperties().getProperty("userEmail"));
        getPo().getWelement("registrationUsername").sendKeys(PropertyReader.getProperties().getProperty("userName"));
        getPo().getWelement("registrationPassword").sendKeys(PropertyReader.getProperties().getProperty("userPassword"));
        getPo().getWelement("registrationConfirmPassword").sendKeys(PropertyReader.getProperties().getProperty("userPassword"));
        getPo().getWelement("registerNewAccountButton").click();
        getPo().getWelement("loginEmail").sendKeys(PropertyReader.getProperties().getProperty("userEmail"));
        getPo().getWelement("loginPassword").sendKeys(PropertyReader.getProperties().getProperty("userPassword"));
        getPo().getWelement("signInButton").click();
        String actualPageName=getPo().getWelement("pageName").getText();

        Assert.assertEquals(actualPageName, expectedPageName,"The page has correct name");







    }

}
