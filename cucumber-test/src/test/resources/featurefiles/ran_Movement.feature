@tag
  Feature: Movement of a robot
  I want to use this template for my feature file

  @tag1   
  Scenario Outline: Successful movement
    Given your robot life is not 0
    And IsYourTurn status is true
    And position x is 3 y is 2
    When orientation is <Orien>
    #And the new position is valid 
    Then  move to a new <Orien> position x is <X> y is <Y> 


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
    
    When start orientation is <OrientStart>
    And rotate to the <Rotate>
    Then end orientation is <OrientEnd> 


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
    


    

