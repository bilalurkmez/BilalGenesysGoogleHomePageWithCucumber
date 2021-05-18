package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.GoogleHomePage;
import utilities.Config;
import utilities.Driver;


public class Google_Steps {

    static WebDriver driver = Driver.getDriver();
    static GoogleHomePage googleHomePage = new GoogleHomePage();

    @When("User is on Google search page")
    public void user_is_on_Google_search_page() {
        driver.get(Config.getProperty("googleURL"));
    }

    @Then("User should see {string} as the page title")
    public void user_should_see_as_the_page_title(String item) {
        String actualTitle = driver.getTitle();
        String expectedTitle = item;
        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

    @When("User types {string} in the Google Search box")
    public void user_types_in_the_google_search_box(String searchKey) throws InterruptedException {
        googleHomePage.searchBox.click();
        googleHomePage.searchBox.sendKeys(searchKey);
    }

    @When("User clicks on the Google Search button on the Google page")
    public void user_clicks_on_the_google_search_button_on_the_google_page() {
        googleHomePage.searchButton.click();
    }

    @Then("User sees {string} is in the page title")
    public void user_sees_is_in_the_page_title(String title) {
        String actualTitle = driver.getTitle();
        String expectedTitle = title;
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @When("User clicks on the Privacy button")
    public void user_clicks_on_the_privacy_button() {
        googleHomePage.privacyButton.click();
    }

    @Then("User is navigated to the Google Privacy&Terms page and the Privacy Policy tab is selected")
    public void user_is_navigated_to_the_google_privacy_terms_page_and_the_privacy_policy_tab_is_selected() {
        Assert.assertTrue(googleHomePage.privacyPolicyTab.isEnabled());
    }

    @Then("User is navigated to the Search Results page and the Search Results page shows how many results are found in how many seconds.")
    public void user_is_navigated_to_the_search_results_page_and_the_search_results_page_shows_how_many_results_are_found_in_how_many_seconds() {
        String actualResultStatement = googleHomePage.resultsStatement.getText();
        String [] expectedKeyWords = {"About", "results", "seconds"};
        for(int i=0; i<expectedKeyWords.length; i++){
            Assert.assertTrue(actualResultStatement.contains(expectedKeyWords[i]));
        }
    }

    @Then("User sees the Your search - {string} - did not match any documents. message")
    public void user_sees_the_your_search_did_not_match_any_documents_message(String invalidValue) {
        String actualMessage = googleHomePage.yourSearchDidNotMatchMessage.getText();
        String expectedMessage = "Your search - " + invalidValue + " - did not match any documents.";
        Assert.assertTrue(actualMessage.equals(expectedMessage));
    }

    @When("User hovers over the I'm Feeling Lucky button")
    public void user_hovers_over_the_i_m_feeling_lucky_button() {

    }

    @Then("User sees that content of the I'm Feeling Lucky button is dynamic")
    public void user_sees_that_content_of_the_i_m_feeling_lucky_button_is_dynamic() {

    }

    @When("User keeps hovering over the I'm Feeling Lucky button until the content of the button is {string} and clicks on the button")
    public void user_keeps_hovering_over_the_i_m_feeling_lucky_button_until_the_content_of_the_button_is_and_clicks_on_the_button(String buttonContent) throws InterruptedException {
        String xpathValue = "\"//span[contains(text(),\"" + buttonContent + "]";
        Actions trial = new Actions(driver);
        while(true){
            trial.moveToElement(googleHomePage.ImFeelingLuckyButton).perform();
            Thread.sleep(1000);
            if(googleHomePage.buttonContent.getText().equals("I'm Feeling Hungry")){
                googleHomePage.buttonContent.click();
                break;
            }
            trial.moveToElement(googleHomePage.privacyButton).perform();
            Thread.sleep(1000);
        }
    }

    @Then("User is navigated to search results page which includes close food places and the page title includes {string} word")
    public void user_is_navigated_to_search_results_page_which_includes_close_food_places_and_the_page_title_includes_word(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

}
