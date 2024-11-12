package steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CareerApplicationSteps {

	WebDriver driver = new ChromeDriver();

	@Given("^I open the browser and navigate to the LabCorp website$")
	public void openLabCorpWebsite() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.labcorp.com");
	}

	@When("^I click on the Careers link$")
	public void clickCareersLink() {
		WebElement careersLink = driver.findElement(By.linkText("Careers"));

//		Extra Bys

//		WebElement careersLink = driver.findElement(By.xpath("//*[@id="text-a63751913f"]//a"));
//		WebElement careersLink = driver.findElement(By.cssSelector("#text-a63751913f > p > a"));

		careersLink.click();
	}

	@And("^I search for the job title \"([^\"]*)\"$")
	public void searchJobTitle(String jobTitle) {
		WebElement searchBox = driver.findElement(By.id("typehead"));

//		Extra Bys

//		WebElement searchBox = driver.findElement(By.cssSelector("#typehead"));
//		WebElement searchBox = driver.findElement(By.xpath("//input[@id='typehead']"));

		searchBox.sendKeys(jobTitle);
		WebElement searchButton = driver.findElement(By.id("ph-search-backdrop"));
		searchButton.click();
	}

	@And("^I select the job from the list$")
	public void selectJobFromList() {
		WebElement jobLink = driver.findElement(By.partialLinkText("QA Test Automation Developer"));
		jobLink.click();
	}

	@Then("^I should verify the job details$")
	public void verifyJobDetails() {
		WebElement jobTitle = driver.findElement(By.xpath("//h1[contains(text(),'QA Test Automation Developer')]"));
		WebElement jobLocation = driver.findElement(By.xpath("//span[contains(text(),'Bangalore, India')]"));
		WebElement jobId = driver.findElement(By.xpath("//span[contains(text(),'2430746')]"));
		WebElement descriptionText = driver.findElement(By.xpath("//p[contains(text(),'5-10 years relevant')]"));
		WebElement managementElement = driver.findElement(By.xpath("//div[contains(@class, 'management')]"));
		WebElement expElement = driver.findElement(By.xpath("//div[contains(text(),'5+ years of experience')]"));
		WebElement containsElement = driver.findElement(By.xpath("//div[contains(text(),'Selenium')]"));

		Assert.assertEquals("QA Test Automation Developer", jobTitle.getText().trim());
		Assert.assertEquals("Bangalore, India", jobLocation.getText().trim());
		Assert.assertEquals("2430746", jobId.getText().trim());
		Assert.assertTrue(descriptionText.getText().trim().startsWith("5-10 years relevant"));
		Assert.assertTrue(managementElement.getText().trim().startsWith("Test Plans"));
		Assert.assertTrue(expElement.getText().trim().startsWith("5+ years of experience"));
		Assert.assertTrue(containsElement.getText().trim().contains("Selenium"));
	}

	@When("^I click on the Apply Now button$")
	public void clickApplyNowButton() {
		WebElement applyNowButton = driver.findElement(By.id("apply-now-button"));
		applyNowButton.click();
	}

	@Then("^I should verify that the application page displays the same job details$")
	public void verifyApplicationPageJobDetails() {
		WebElement jobTitle = driver.findElement(By.xpath("//h1[contains(text(),'QA Test Automation Developer')]"));
		WebElement jobLocation = driver.findElement(By.xpath("//span[contains(text(),'Bangalore, India')]"));
		WebElement jobId = driver.findElement(By.xpath("//span[contains(text(),'2430746')]"));
		WebElement descriptionText = driver.findElement(By.xpath("//p[contains(text(),'5-10 years relevant')]"));
		WebElement managementElement = driver.findElement(By.xpath("//div[contains(@class, 'management')]"));
		WebElement expElement = driver.findElement(By.xpath("//div[contains(text(),'5+ years of experience')]"));
		WebElement containsElement = driver.findElement(By.xpath("//div[contains(text(),'Selenium')]"));

		Assert.assertEquals("QA Test Automation Developer", jobTitle.getText().trim());
		Assert.assertEquals("Bangalore, India", jobLocation.getText().trim());
		Assert.assertEquals("2430746", jobId.getText().trim());
		Assert.assertTrue(descriptionText.getText().trim().startsWith("5-10 years relevant"));
		Assert.assertTrue(managementElement.getText().trim().startsWith("Test Plans"));
		Assert.assertTrue(expElement.getText().trim().startsWith("5+ years of experience"));
		Assert.assertTrue(containsElement.getText().trim().contains("Selenium"));
	}

	@When("^I return to the job search$")
	public void returnToJobSearch() {
		WebElement backToSearchButton = driver.findElement(By.id("back-to-search-button"));
		backToSearchButton.click();
	}

}
