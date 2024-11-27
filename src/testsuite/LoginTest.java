package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValiCredentials() {

        //* Enter “standard_user” for the username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        //* Enter “secret_sauce” for the password
        sendTextToElement(By.xpath(" //input[@id='password']"), "secret_sauce");
        //* Click on the ‘Login’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        //* Verify the text “Products”
        //  assertMethod("Products" , By.xpath("//span[@class='title']"));
        Assert.assertEquals(getTextFromElement(By.className("title")), "Products");


    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //* Enter “standard_user” for the username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");

        //* Enter “secret_sauce” for the password
        sendTextToElement(By.xpath(" //input[@id='password']"), "secret_sauce");
        //* Click on the ‘Login’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //* Verify that six products are displayed on page
        int productCount = driver.findElements(By.className("inventory_item")).size();
        Assert.assertEquals(productCount, 6);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
