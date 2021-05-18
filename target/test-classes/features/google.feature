@google
Feature: Google Title verifications

  Background: Navigate to Google page
    When User is on Google search page

  @googlePageTitle
  Scenario: Google title verification
    Then User should see "Google" as the page title

  @pageTitleForGoogleSearch
  Scenario Outline: Page Title Verification for Google Search
    When User types "<searchKey>" in the Google Search box
    And  User clicks on the Google Search button on the Google page
    Then User sees "<title>" is in the page title

    Examples: Test data for verification
      |searchKey    |title        |
      |Apples       |Apple        |
      |Pencil       |Pencil       |
      |Lady Gaga    |Lady Gaga    |

  @googlePrivacyButton
  Scenario: Privacy button functionality
    When User clicks on the Privacy button
    Then User is navigated to the Google Privacy&Terms page and the Privacy Policy tab is selected

  @googleNavigationToSearchResults
  Scenario: Verification for Navigating to Search Results Page
    When User types "Genesys" in the Google Search box
    And  User clicks on the Google Search button on the Google page
    Then User is navigated to the Search Results page and the Search Results page shows how many results are found in how many seconds.

  @googleInvalidValueSearch
  Scenario: Verification of No Match Message
    When User types "@#$%^" in the Google Search box
    And  User clicks on the Google Search button on the Google page
    Then User sees the Your search - "@#$%^" - did not match any documents. message

  @googleDynamicImFeelingLuckyButton
  Scenario: Clicking on a specific option for the I'm Feeling Lucky button
    When User hovers over the I'm Feeling Lucky button
    Then User sees that content of the I'm Feeling Lucky button is dynamic
    When User keeps hovering over the I'm Feeling Lucky button until the content of the button is "I'm Feeling Hungry" and clicks on the button
    Then User is navigated to search results page which includes close food places and the page title includes "near" word





