package com.employee;

import com.employee.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @Sql(scripts= "/testsql/insert-test-employees.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts= "/testsql/delete-test-employees.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void givenAllEmployeesURL_whenCallGETMethod_thenReceiveJSONOkRespond() throws Exception {
        mvc.perform(
                get("/employees").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content[0].name", is("otts1")))
                .andExpect(jsonPath("$.content[0].email", is("otts1@gmail.com")))
                .andExpect(jsonPath("$.content[0].department", is("Software")))
        ;
    }
}
