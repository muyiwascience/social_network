Feature: Make a Post

  @PostData
  Scenario: Make a post to the social network site
    Given I navigate to the api URI
    When I make a post using these data "12" "101" "I love this city" "I like everybody there"
    Then I get Http response code "201"

