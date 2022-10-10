Feature: Contact Sales feature

@Skip
Scenario Outline: Contact sales scenario wih different sets of data
Given User navigates to Contact Sales page
When User fills the form using "<SheetName>" and rownumber <RowNumber>
And User clicks on Im not robot
And User clicks on Submit button
Then It shows "Thank you!" message to user

Examples:
|SheetName|RowNumber|
|contactsales|0|
|contactsales|1|