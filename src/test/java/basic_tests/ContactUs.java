package basic_tests;

import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

import static helper.Pages.HOME;

public class ContactUs {

    @Test
        // The test verifies the contact us form.

    public void test(){

        WebDriver driver = DriverFactory.newDriver();

        driver.get(HOME);
        // Goes to the main page.

        DriverFactory.closeCookiesConsent(driver);
        // Closes the cookies.

        WebElement ContactUs = driver.findElement(By.cssSelector(".g01__primary-button.wp-block-button__link"));
        ContactUs.click();
        // Goes to the Contact Us page.

        WebElement FirstName = driver.findElement(By.id("FirstName"));
        FirstName.click();
        FirstName.sendKeys("Bahur");
        // Fills the First Name field.


        WebElement LastName = driver.findElement(By.id("LastName"));
        LastName.click();
        LastName.sendKeys("Bahurov");
        // Fills the Last Name field.

        WebElement Email = driver.findElement(By.id("Email"));
        Email.click();
        Email.sendKeys("Bahur.Bahurov@bahur.com");
        // Fills the email field.

        WebElement Subject = driver.findElement(By.id("Products_of_Interest__c_lead"));
        Subject.click();
        WebElement ContactCustomerSupport = driver.findElement(By.cssSelector("#Products_of_Interest__c_lead > option:nth-child(3)"));
        ContactCustomerSupport.click();
        // Selects the Customer support from the drop-down.

        WebElement Company = driver.findElement(By.id("Company"));
        Company.click();
        Company.sendKeys("Bahur.ltd");
        // Fills the Company field

        WebElement CheckBox = driver.findElement(By.name("mktoOptIn"));
        CheckBox.click();
        // Checks the Checkbox.

        WebElement SubmitBtn = driver.findElement((By.cssSelector("#mktoForm_2119 > div.mktoButtonRow > span > button")));
        Assert.assertEquals(SubmitBtn.getText(), "Submit");
        // The Submit button is available. It's on prod, so we don't want to send real quarry.

        driver.quit();
    }

        @Test

        // This test verifies the San Francisco and Sofia offices are displayed in the Contact us page.
    public void test_find_offices(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        try {

            DriverFactory.closeCookiesConsent(driver);
            // Closes the cookies.

            WebElement ContactUs = driver.findElement(By.cssSelector(".g01__primary-button.wp-block-button__link"));
            ContactUs.click();
            // Goes to Contact Us page.

            WebElement find_offices = driver.findElement(By.cssSelector("#Form > div > div.b45__content > div > div > a"));
            find_offices.click();
            // Goes to the offices.

            WebElement SanFrancisco = driver.findElement(By.cssSelector("#block_b24d4259b6d4d541c0fe8d91075aec16 > div > div.wp-block-columns.has-width-default.is-layout-flex.wp-container-core-columns-layout-1.wp-block-columns-is-layout-flex > div:nth-child(1) > h2 > strong"));
            Assert.assertEquals(SanFrancisco.getText(), "San Francisco, CA");
            // Asserts the San Francisco office is available.

            WebElement EMEA = driver.findElement(By.cssSelector(".b04__tabs.b04__tabs--desktop > button:nth-of-type(2)"));
            Thread.sleep(2000);
            EMEA.click();
            // Goes to EMEA offices.

            WebElement SofiaOffice = driver.findElement(By.cssSelector("#block_b24d4259b6d4d541c0fe8d91075aec16 > div > div.wp-block-columns.has-width-default.is-layout-flex.wp-container-core-columns-layout-4.wp-block-columns-is-layout-flex > div:nth-child(1) > h2 > strong"));
            Assert.assertEquals(SofiaOffice.getText(), "Sofia, Bulgaria");
            // Asserts the Sofia office is available.


            }catch (InterruptedException e) {
            e.printStackTrace();  // Handle the exception appropriately
        } finally {
            driver.quit();
        }
    }

//    // in progress
//    // @Test
//
//    public void offices() {
//        WebDriver driver = DriverFactory.newDriver();
//        driver.get(HOME);
//        DriverFactory.closeCookiesConsent(driver);
//
//        WebElement ContactUs = driver.findElement(By.cssSelector(".g01__primary-button.wp-block-button__link"));
//        ContactUs.click();
//        WebElement FindOurOffices = driver.findElement(By.cssSelector(".wp-block-button .wp-block-button__link"));
//        FindOurOffices.click();
//
//        WebElement buttonsContainer = driver.findElement(By.cssSelector("#block_fdbd2a90bf7d33d5cfc88b1c3e231f00 > div > div.b04__controls > nav"));
//
//        List<WebElement> buttons = buttonsContainer.findElements(By.cssSelector("button.b04__tab"));
//        for (int i = 0; i < buttons.size(); i++) {
//            // Click the button at current index
//            buttons.get(i).click();
//
//
//            WebDriverWait wait = DriverFactory.createWebDriverWait(driver);
//            WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#block_b24d4259b6d4d541c0fe8d91075aec16 > div > div.wp-block-columns.has-width-default.is-layout-flex.wp-container-core-columns-layout-1.wp-block-columns-is-layout-flex > div:nth-child(1)")));
//            // Wait for the table to be visible
//
//
//            String tableText = table.getText();
//            String expectedText = "San Francisco, CA";
//            // Verify if the table contains expected text
//
//            if (tableText.contains(expectedText)) {
//                System.out.println("Verification passed for button at index " + i);
//            } else {
//                System.out.println("Verification failed for button at index " + i);
//                // Optionally take further actions or capture screenshots for debugging
//            }
//
//        }
//    }
}
