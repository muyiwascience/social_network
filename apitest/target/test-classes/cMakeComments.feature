Feature: Make a Comment

  @Comments
  Scenario: Make a comments to the social network site
    Given I navigate to the api URI
    When I make comments to the post using these data "101" "doloribus dolores ut dolores occaecati" "Dolly@mandy.co.uk"
    Then I get Http response code "201"