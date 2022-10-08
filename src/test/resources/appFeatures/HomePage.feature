Feature: Orange HRM home page features

Background:
Given User has logged in to the application
|username|password|
|Admin|admin123|
Then User click on application logo

Scenario: Homepage title
Given User is on homepage
And User gets the title of the page
Then Page title should be "OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM!!!"

Scenario: Verify homepage sections
Given User is on homepage
And User gets homepage sections
|Platform|
|Why OrangeHRM|
|Resources|
|Company|
Then Homepage section count should be 4
 