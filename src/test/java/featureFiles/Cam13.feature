Feature: Discount Functionality

  Background: Login, Parameters and Nationalities Functionalities

    Given Navigate to Campus
    When Enter username and password and click button
    Then User should login successfully
    And Click on the element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |


  Scenario Outline: Nationalities Add Feature (Positive Test)

    Then Click on the element in Dialog
      | addButton |

    When User sending the keys in Dialog Content
      | nameInput | <name> |

    And Click on the element in Dialog
      | saveButton |

    Then Click on the element in Dialog
      | successMessage |

    Examples:
      | name    |
      | Ivorian |


  Scenario Outline: Nationalities Add Feature (Negative Test)

    Then Click on the element in Dialog
      | addButton |

    When User sending the keys in Dialog Content
      | nameInput | <name> |

    And Click on the element in Dialog
      | saveButton |

    Then Click on the element in Dialog
      | alreadyExist |

    Examples:
      | name    |
      | Ivorian |


  Scenario Outline: Nationalities Edit Feature

    Then User sending the keys in Dialog Content
      | searchInput | <name> |

    And Click on the element in Dialog
      | searchButton |

    Then Click on the element in Dialog
      | editButton |

    Then User sending the keys in Dialog Content
      | nameInput | <nameEdit> |

    Then Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    Examples:
      | name    | nameEdit |
      | Ivorian | Danish   |


  Scenario Outline: Nationalities Delete Feature (Positive Test)

    Then User delete item from Dialog Content
      | <name> |

    Then Success message should be displayed

    Examples:
      | name   |
      | Danish |


  Scenario Outline: Nationalities Delete Feature (Negative Test)

    Then User sending the keys in Dialog Content
      | searchInput | <name> |

    And Click on the element in Dialog
      | searchButton |

    Then There is no data to display message is displayed

    Examples:
      | name   |
      | Danish |
