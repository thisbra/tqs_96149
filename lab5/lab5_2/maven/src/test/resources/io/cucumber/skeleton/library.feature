Feature: Library Book Search

  Scenario: Search for books published between two dates
    Given y:
      | Title         | Author      | Published   |
      | Book A        | Author A    | 2020-01-01  |
      | Book B        | Author B    | 2019-01-01  |
      | Book C        | Author C    | 2021-01-01  |
    When I search for books published between 2019-01-01 and 2021-01-01
    Then the following books should be returned:
      | Title         | Author      | Published   |
      | Book A        | Author A    | 2020-01-01  |
      | Book C        | Author C    | 2021-01-01  |

