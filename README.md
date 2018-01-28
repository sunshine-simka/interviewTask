# Task
Create an automated test plan to verify this single page application is working correctly. Your automated test plan should be written using Selenium and Java. The acceptance criteria for the form are outlined below.
## Test case 1
- Given: User has been given access to the ABC document
- When: User opens the link to the ABC document
- Then: User should be able to clearly view the ABC document
## Test case 2
-  Given: User is viewing the document
- When: User views top of the document
- Then: User should see that the document contains a valid title and description that has been given by the page creator.
## Test case 3
-  Given: User is viewing the document
- When: User views the available sections of the document
- Then: User should see that the First Name is required as indicated by the red alert at the top of the page.
## Test case 4
- Given: User enters at least some information in all fields with the exception of the 'First Name' field
- When: User selects 'Submit' button to submit their response
- Then: User will see that the first name field has been highlighted in red and displays the message 'This is a required question' under the answer line
## Test case 5
- Given: User has completed all required fields
- When: User attempts to submit their response
- Then: User should receive a success message that states 'Your response has been recorded'

