Feature: Service Page tests

  Scenario: Service Page Interface Test
    Given I open the Home Page
    Then Browser title should be 'Home Page'
    When I log in as user epam with password 1234
    Then The user icon should be displayed on the header
    And Username should be 'PITER CHAILOVSKII'
    When I check interface on the Home page
    Then The following elements should be displayed:
      | 4 - pictures                                |
      | 4 texts under pictures                      |
      | 2 texts pictures (headline and description) |
    When I click on 'Service' subcategory in the header
    Then Drop down should contain the following options:
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | User Table         |
      | Tables With Pages  |
      | Different Elements |
      | Performance        |
    When I click on Service subcategory in the left section
    Then Drop down should contain the following options:
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | User Table         |
      | Tables With Pages  |
      | Different Elements |
      | Performance        |
    When I open 'Different Elements Page' through the header menu Service
    Then 'Different Elements Page' should be opened
    When I check interface on 'Different elements page'
    Then The following elements should be displayed on 'Different elements page':
      | 4 checkboxes   |
      | 4 radiobuttons |
      | 1 dropdown     |
      | 2 buttons      |
    And Right Section should be displayed
    And Left Section should be displayed
    When I select checkboxes
      | Wind  |
      | Water |
    Then checkboxes should be checked
    And each checkbox should have individual entry in the log with value which is corresponded to the status of checkbox
    When I select radiobutton "SELEN"
    Then The radiobutton should have individual entry in the log with value which is corresponded to the status of radiobutton
    When I select "Yellow" in dropdown
    Then The log should have individual entry with value which is corresponded to the status of the selected value
    When I unselected checkboxes
    Then checkboxes should be unchecked
    And each checkbox should have individual entry in the log with value which is corresponded to the status of checkbox