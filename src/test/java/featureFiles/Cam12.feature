Feature: Discount Functionality

  Background: Login, Parameters and Discounts Functionalities
    Given Navigate to Campus
    When Enter username and password and click button
    Then User should login successfully
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | discounts  |

  Scenario Outline: Discounts Add Feature (Positive Test)
    Then Click on the element in Dialog
      | addButton |

    When User sending the keys in Dialog Content
      | description              | <descriptionInput> |
      | discountsIntegrationCode | <intCode>          |
      | priorityCode             | <prrtyCode>        |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    Then Click on the element in Dialog
      | successMessage |

    Examples:
      | descriptionInput | intCode | prrtyCode |
      | Cam12            | 13      | 14        |

  Scenario Outline: Discounts Add Feature (Negative Test)
    Then Click on the element in Dialog
      | addButton |

    When User sending the keys in Dialog Content
      | description              | <descriptionInput> |
      | discountsIntegrationCode | <intCode>          |
      | priorityCode             | <prrtyCode>        |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    Then Click on the element in Dialog
      | alreadyExist |

    Examples:
      | descriptionInput | intCode | prrtyCode |
      | Cam12            | 13      | 14        |

  Scenario Outline: Discounts Edit Feature
    When User sending the keys in Dialog Content
      | descriptionSearch              | <descriptionInput> |
      | discountsIntegrationCodeSearch | <intCode>          |

    And User editing Discount Data

    Then Success message should be displayed

    Examples:
      | descriptionInput | intCode |
      | Cam12            | 13      |

  Scenario Outline: Discounts Delete Feature (Positive Test)
    Then User delete input from Dialog Content
      | <descriptionInput> |

    Then Success message should be displayed

    Examples:
      | descriptionInput |
      | Cam99            |

  Scenario Outline: Discounts Delete Feature (Negative Test)
    When User sending the keys in Dialog Content
      | descriptionSearch              | <descriptionInput> |
      | discountsIntegrationCodeSearch | <intCode>          |

    And Click on the element in Dialog
      | searchButton |

    Then There is no data to display message is displayed

    Examples:
      | descriptionInput | intCode |
      | Cam99            | 44      |