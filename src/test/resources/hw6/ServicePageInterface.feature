Feature: Service Page Interface BDD

  Scenario: Check Service Page Interface
    Given I am on "Home Page"
    Then Browser title is Home Page
    When I login as user PITER CHAILOVSKII
    Then User name is PITER CHAILOVSKII
    And Page contains: 4 pictures, 4 texts under them, 2 texts above - headline and description

    When I click on SERVICE button in Header
    Then Service drop-down list in header contains options:
      |Support|
      |Dates|
      |Complex Table|
      |Simple Table|
      |User Table|
      |Table with pages|
      |Different Elements|
      |Performance|

    When I click on Service subcategory in the left menu
    Then Service drop-down list in left menu contains options:
      |Support|
      |Dates|
      |Complex Table|
      |Simple Table|
      |User Table|
      |Table with pages|
      |Different Elements|
      |Performance|

    And I open Different Elements page from 'Service' dropdown
    Then Page contains left section
    And Page contains right section
    When I click on checkbox: Water
    Then Corresponding log appears according to selected checkbox: 'Water'': condition changed to ''true'
    When I click on checkbox: Wind
    Then Corresponding log appears according to selected checkbox: 'Wind'': condition changed to ''true'
    When I select Selen radiobutton
    Then Corresponding log appears according to selected radiobutton: 'metal: value changed to ''Selen'
    When I select Yellow in drop-down list
    Then Corresponding log appears according to selected option in drop-down list: 'Colors: value changed to ''Yellow'
    When I click on checkbox: Water
    Then Corresponding log appears according to selected checkbox: 'Water'': condition changed to ''false'
    When I click on checkbox: Wind
    Then Corresponding log appears according to selected checkbox: 'Wind'': condition changed to ''false'