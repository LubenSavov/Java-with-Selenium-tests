package basic_tests;

import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class Page_Title {

    @Test
        // The test verifies the main page opening and its title.

    public void home_page_title(){
        WebDriver driver = DriverFactory.newDriver();

        driver.get(HOME); // opens the main page.
        WebElement title = driver.findElement(By.cssSelector("#header > div.g01__secondary > div > div > span"));
        // finds the title


        Assert.assertEquals(title.getText(), "Taulia is now part of SAP");
        // Asserts the title is "Taulia is now part of SAP".

        driver.quit();
    }

}
