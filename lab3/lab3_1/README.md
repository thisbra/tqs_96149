# 3.1)

## a) Identify a couple of examples that use AssertJ expressive methods chaining.

On A_EmployeeRepositoryTest

```
assertThat( found ).isEqualTo(alex)  
assertThat(fromDb).isNull()
```

## b) Identify an example in which you mock the behavior of the repository (and avoid involving a database).

Test B is a unit test that does not trigger database testing. Only JUnit5 and Mockito are used to test EmployeeServiceImpl interface without testing EmployeeRepositorym mocking EmployeeRepository.


## c)
@Mockbean is used only on the Spring framework context, but @Mock can be used in any context. 


## d)
Because Jpa instanciates a database without needing a real database, the `application-integrationtest.properties` file dictates the configuration of this database.


## e)
- Test C doesn't use the database, while D and E do. 
- D and E are integration test that involves many components, but D use Mockvc as entrypoint and E uses TestRestTemplate.
