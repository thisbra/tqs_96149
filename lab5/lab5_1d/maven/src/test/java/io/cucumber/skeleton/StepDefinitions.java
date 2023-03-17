package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
//    @Given("I have {int} cukes in my belly")
//    public void I_have_cukes_in_my_belly(int cukes) {
//        Belly belly = new Belly();
//        belly.eat(cukes);
//    }
//
//    @When("I wait {int} hour")
//    public void i_wait_hour(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        Belly belly = new Belly();
//        belly.wait(int1);
//    }
//
//    @Then("my belly should growl")
//    public void my_belly_should_growl() {
//        Belly belly = new Belly();
//        belly.growl();
//    }

        private Calculator calc;

        @Given("a calculator I just turned on")
        public void setup() {
            calc = new Calculator();
        }

        @When("I add {int} and {int}")
        public void add(int arg1, int arg2) {
            calc.push(arg1);
            calc.push(arg2);
            calc.push("+");
        }

        @When("I substract {int} to {int}")
        public void substract(int arg1, int arg2) {
            calc.push(arg1);
            calc.push(arg2);
            calc.push("-");
        }

        @Then("the result is {double}")
        public void the_result_is(double expected) {
            assertEquals(expected, calc.value());
        }


}
