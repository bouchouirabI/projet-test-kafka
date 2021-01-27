package com.project.app.cucumber.client;

import com.project.app.cucumber.TestUtils;
import com.project.app.entity.Client;
import com.project.app.repository.ClientRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RequiredArgsConstructor
public class ClientStepDefinitions {

    private final ClientRepository clientRepository;

    private final MockMvc mockMvc;

    private ResultActions postEventAction;


    @Given("I have no clients in database")
    public void i_have_no_clients_in_database(){
        Long existingClients = clientRepository.count();
        assertThat(existingClients).isEqualTo(0l);
    }

    @When("I receive the request to add a client with the body")
    public void i_receive_the_request_to_add_a_client_with_the_body(DataTable dataTable) throws Exception {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        postEventAction =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/clients")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(TestUtils.convertObjectToJsonBytes(rows.get(0))));

    }

    @Then("Response should be ok")
    public void response_should_be_ok() throws Exception {
        postEventAction.andExpect(status().is(HttpStatus.OK.value())).andReturn();
    }

    @Then("Database should contain")
    public void database_should_contain(DataTable dataTable){
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        List<Client> expectedClients = Arrays.asList(Client.builder()
                .firstName(rows.get(0).get("firstName"))
                .lastName(rows.get(0).get("lastName"))
                .middleName(rows.get(0).get("middleName"))
                .dateOfBirth(LocalDate.parse(rows.get(0).get("dateOfBirth")))
                .placeOfBirth(rows.get(0).get("placeOfBirth"))
                .email(rows.get(0).get("email"))
                .enrollmentDate(LocalDate.now())
                .build());

        List<Client> actualClients = clientRepository.findAll();

        assertThat(expectedClients)
                .usingFieldByFieldElementComparator()
                .usingElementComparatorIgnoringFields("id")
                .hasSameElementsAs(expectedClients);
    }
}
