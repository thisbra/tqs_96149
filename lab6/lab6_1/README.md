### Sonar Static Analysis

|    Issue     |    Value   |   Grade   |        Problem Description        |                     How to solve                     |
|:------------:|:----------:|:---------:|:--------------------------------:|:---------------------------------------------------:|
|     Bugs     |      0     |     A     | No bugs were found in this code  |                Review and fix                       |
|Vulnerabilities|      0     |     A     | No vulnerabilites found in this code | Review possible vulnerability sources and fix them |
|  Code Smell  |     20     | Major: 5  | Performance hit with Preconditions and string concatenation. | Use static/pre-computed values, string formatting, and conditional exceptions. |
|Security Hotspots|    20    |   MEDIUM  | Make sure that using this pseudorandom number generator is safe | Use secure unpredictable generation mechanism or unique values. |
|Technical Debts|   1h10m    |     A     | The amout of time to correct current Technical debts in the code should take more than 1 hour | Always write easily maintanable code |
|   Coverage   |    72.5%   |Reasonable| Limited code coverage may result in insufficient test coverage. | Increase test coverage and improve quality of test cases.|
