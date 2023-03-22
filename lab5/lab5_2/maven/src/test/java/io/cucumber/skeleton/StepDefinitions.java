package io.cucumber.skeleton;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    Library library = new Library();
    List<Book> searchResults;

    SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");

    @Given("the following books exist in the library:")
    public void the_following_books_exist_in_the_library(List<Book> books) {
        for (Book book : books) {
            library.addBook(book);
        }
    }

    @When("^I search for books published between (.*) and (.*)$")
    public void i_search_for_books_published_between(String fromString, String toString) {
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date from = formatter1.parse(fromString);
            Date to = formatter1.parse(toString);
            searchResults = library.findBooks(from, to);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Then("^the following books should be returned:$")
    public void the_following_books_should_be_returned(List<Book> expectedBooks) {
        assertEquals(expectedBooks, searchResults);
    }
}


}
