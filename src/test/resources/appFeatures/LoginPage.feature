Feature: Login page feature

Scenario: Login page title
Given User is on login page
And User gets the title of the page
Then Page title should be "OrangeHRM"

Scenario: Forgot Password link
Given User is on login page
Then Forgot your password link should be displayed

Scenario: Login with correct credentials
Given User is on login page
When User enters username "Admin"
And User enters password "admin123"
And User clicks on Login button
Then User gets the title of the page
And Page title should be "OrangeHRM"