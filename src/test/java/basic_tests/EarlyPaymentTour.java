package basic_tests;

import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static helper.Pages.HOME;

public class EarlyPaymentTour {

    @Test

    // The test verifies the tour of Early payment knowledge page is working correctly.
    public void EarlyPaymentTest(){

    WebDriver driver = DriverFactory.newDriver();

        driver.get(HOME);
        // Goes to the main page.

        DriverFactory.closeCookiesConsent(driver);
        // Closes the Cookies popup.

        WebElement Platform = driver.findElement(By.cssSelector("li:nth-of-type(1) > .g01__menu-item__link"));
        Platform.click();
        // Goes to Platform menu.

        WebElement EarlyPaymentPage = driver.findElement(By.cssSelector("#header-primary-menu > li:nth-child(1) > div > ul > li:nth-child(8) > ul > li:nth-child(1) > a"));
        EarlyPaymentPage.click();
        // Goes to Early Payment Page

        WebElement TakeATour = driver.findElement(By.cssSelector("#block_e44e7a9e2f0c9096d01b0fae68ce659d > div > div > div.b14__ctas > div:nth-child(1) > a"));
        TakeATour.click();
        // Starts the Early Payment tour.

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Switch to new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Goes to the next tab

        WebElement Popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.nv-scale-dialog-center.css-3a72m7 > div > div > div > div > div.css-1cs86xj > div > div > div > div > div > h2 > div")));
        Assert.assertEquals(Popup.getText(), "Welcome to an interactive tour of Taulia's supplier experience! ");
        // Asserts the new tab pops up and its title is displayed.

        WebElement GetStarted = driver.findElement(By.cssSelector("button[role='button']"));
        GetStarted.click();
        // Starts the tour.

        WebElement ActivateMyAccount =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#clickable-area")));
        ActivateMyAccount.click();
        // Activates the account.

        WebElement TermsAndConditions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#clickable-area")));
        TermsAndConditions.click();
        // Accepting the Terms And Conditions.

        WebElement ManageCashFlows = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#clickable-area")));
        ManageCashFlows.click();
        // Manages the cash flows.

        WebElement InviteUsers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#clickable-area")));
        InviteUsers.click();
        // Invites users.

        WebElement ContinueTour = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.nv-scale-dialog-center.css-3a72m7 > div > div > div > div > div.css-11y9t1a > button.navattic-btn-secondary.css-dlkvqr")));
        ContinueTour.click();
        // Continues with the tour.

        WebElement Next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.nv-scale-dialog-center.css-3a72m7 > div > div > div > div > div.css-11y9t1a > button")));
        Next.click();
        // Continues on next page.

        WebElement OrganizationSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#clickable-area")));
        OrganizationSelect.click();
        // Selects the organization.

        WebElement ApprovedInvoice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#clickable-area")));
        ApprovedInvoice.click();
        // Accelerates the approved invoice.

        WebElement CheckTheInvoice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#clickable-area")));
        CheckTheInvoice.click();
        // Checks the invoice.

        WebElement SubmitInvoice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#clickable-area")));
        SubmitInvoice.click();
        // Submits the invoice.

        WebElement EnablesCashflow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#clickable-area")));
        EnablesCashflow.click();
        // Enables Cashflow.

        WebElement EndTour = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.nv-scale-dialog-center.css-3a72m7 > div > div > div > div > div.css-11y9t1a > button.navattic-btn-secondary.css-dlkvqr")));
        EndTour.click();
        // Ends the tour.

        WebElement SupplyChainFinancePage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#block_84dffb40d6d56f9f118892fb616505a6 > div > div > h1")));
        Assert.assertEquals(SupplyChainFinancePage.getText(), "Free up cash that supports your entire supply chain");
        // Asserts the user is back to the Supply Chain Finance page.

        driver.quit();

    }
}
