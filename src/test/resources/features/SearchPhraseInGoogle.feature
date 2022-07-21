Feature: Search for Hadrian page among result

  @TEST_001
  Scenario: Perform search for "Because hackers know hackers best"
    Given I open google home Page and accept cookies
    When I search for "Because hackers know hackers best"
    Then I see "hadrian.io" among the result

  @TEST_002
  Scenario: find Hadrian among 10 pages
    Given I open google home Page and accept cookies
    When I search for "Because hackers know hackers best"
    Then I see "hadrian.io" among first 10 pages
