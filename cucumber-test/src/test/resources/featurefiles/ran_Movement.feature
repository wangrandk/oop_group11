@tag
  Feature: Movement of a robot
  I want to use this template for my feature file

  @tag1   
  Scenario Outline: Successful movement
    Given your robot life is not 0 # to definie not 0, I think you should use Regular Expressions instead of Cucumber Expressions
    And IsYourTurn status is true
    And position x is 3 y is 2
    When move towards <Orien> 
    And  the new position towards <Orien>  x is <X> y is <Y> are valid
    Then  by moving  to <Orien> position x is <X> y is <Y> 


  Examples:
    | Orien|   X |   Y  |
    |    N |   3 |   3  |
    |    W |   2 |   2  | 
    |    S |   3 |   1  |
    |    E |   4 |   2  | 
   

  @tag2
  Scenario Outline: Successful rotate
    Givenyour robot life is not 0
    And IsYourTurn status is true
    
    When  rotate to the <Rotate> from <OrientStart>
    Then end orientation is <OrientEnd> from <OrientStart>


 Examples:
    | OrientStart|   Rotate |   OrientEnd |
    |    N       |   left   |   west      |
    |    N       |   right  |   east      |
    |    W       |   left   |   south     | 
    |    W       |   right  |   north     | 
    |    S       |   left   |   east      |
    |    S       |   right  |   west      |
    |    E       |   left   |   north     | 
    |    E       |   right  |   south     | 
    


    

