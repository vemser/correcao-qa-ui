import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Screenshot {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String urlAllureReport = "http://correcaojenkins.h5hxf2fqatg6aqbf.brazilsouth.azurecontainer.io:8080/job/correcao-qa-pipeline/" + args[0] + "/allure/";


        By inputUsername = By.cssSelector("#j_username");
        By inputSenha = By.cssSelector("#j_password");
        By btnEntrar = By.cssSelector("#main-panel > div > form > button");

        driver.get(urlAllureReport);
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.presenceOfElementLocated(inputUsername));
        driver.findElement(inputUsername).sendKeys("admin");

        wait.until(ExpectedConditions.presenceOfElementLocated(inputSenha));
        driver.findElement(inputSenha).sendKeys("admin");

        wait.until(ExpectedConditions.presenceOfElementLocated(inputSenha));
        driver.findElement(btnEntrar).click();

        Thread.sleep(5000);
        TakesScreenshot screenshot = ((TakesScreenshot) driver);

        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);

        File DestFile = new File("allure-report-screenshot.png");

        FileUtils.copyFile(scrFile, DestFile);

        driver.quit();
    }
}
