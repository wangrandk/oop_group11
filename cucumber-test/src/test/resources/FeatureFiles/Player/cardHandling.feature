Feature: Player can Handle Cards from the subdeck
  As an user I want be able to pass cards from my subdeck to my hand

  Background: 
    Given A player with a subdeck

  Scenario Outline: Selecting cards from the subdeck to the hand
    When player chooses <num_cards> cards
    Then player hand should have <num_cards_hand> cards
    And player subdeck should have <num_cards_subdeck> cards

    Examples: 
      | num_cards | num_cards_hand | num_cards_subdeck |
      |         2 |              2 |                 7 |
      |         3 |              3 |                 6 |
      |         4 |              4 |                 5 |

  Scenario Outline: Selecting cards from the hand to the subdeck
    Given a player with a complete Hand
    When player selects <num_cards> cards from the hand
    Then player should have <num_cards_hand> cards in the hand
    And player should have <num_cards_subdeck> cards in the subdeck

    Examples: 
      | num_cards | num_cards_hand | num_cards_subdeck |
      |         1 |              4 |                 5 |
      |         2 |              3 |                 6 |
      |         3 |              2 |                 7 |
