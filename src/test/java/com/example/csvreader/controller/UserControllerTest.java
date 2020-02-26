package com.example.csvreader.controller;

import com.example.csvreader.model.Output;
import com.example.csvreader.model.UserResult;
import com.example.csvreader.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// UserController Test
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @MockBean // product service - creates a copy of the product service for the test case - prototype
    private UserService userService;

    @Autowired // create the mockito object and automatically inject into the constructor using the @Autowired
    private MockMvc mockMvc;

    // Successful test case
    @Test
    @DisplayName("Get /users")
    void testGetUsers() throws Exception {

        Output output = new Output();

        List<UserResult> users = new ArrayList<>();
        UserResult user = new UserResult("steve", 3254);
        UserResult user1 = new UserResult("paul", 1500);

        users.add(user);
        users.add(user1);


        output.setResults(users);
        doReturn(output).when(userService).getUsers();

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$['results'][0].name", is(user.getName())));
    }
}
