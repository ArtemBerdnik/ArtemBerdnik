Feature: Service Page tests

  Scenario: Service Page Interface Test
    Given I open the Home Page
    Then Browser title should be 'Home Page'
    When I log in as user epam with password 1234
    Then The user icon should be displayed on the header
    And Username should be 'PITER CHAILOVSKII'
    And The following elements should be displayed: 4 pictures, 4 texts under pictures, headline text and description
    When I click on 'Service' subcategory in the header
    Then Drop down should contain the following options: Support, Dates, Complex Table, Simple Table, User Table, Tables With Pages, Different Elements, Performance
    When I click on Service subcategory in the left section
    Then Drop down should contain the following options: Support, Dates, Complex Table, Simple Table, User Table, Tables With Pages, Different Elements, Performance
    When I open 'Different Elements Page' through the header menu Service
    Then 'Different Elements Page' should be opened
    And The following elements should be displayed on 'Different elements page': 4 checkboxes, 4 radiobuttons, dropdown with colors, 2 buttons
    And Right Section should be displayed
    And Left Section should be displayed
    When I select checkboxes "WIND" and "WATER"
    Then "WIND" and "WATER" checkboxes should be checked
    And The log should have individual entry with value which is corresponded to the status of the "WIND" and "WATER" checkboxes
    When I select radiobutton "SELEN"
    Then The log should have individual entry with value which is corresponded to the status of the radiobutton "SELEN"
    When I select "YELLOW" in dropdown
    Then The log should have individual entry with value about selcted "YELLOW" color
    When I unselected checkboxes "WIND" and "WATER"
    Then checkboxes "WIND" and "WATER" should be unchecked
    And The log should have individual entry with value which is corresponded to the status of the "WIND" and "WATER" checkboxes