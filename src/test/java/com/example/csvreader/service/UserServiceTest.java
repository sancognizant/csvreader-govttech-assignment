package com.example.csvreader.service;

import com.example.csvreader.model.Output;
import com.example.csvreader.model.UserDB;
import com.example.csvreader.model.UserResult;
import com.example.csvreader.repository.UserRepository;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.junit5.DBUnitExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@ExtendWith({DBUnitExtension.class, SpringExtension.class})
public class UserServiceTest {

    @Autowired
    private DataSource dataSource;
    public ConnectionHolder connectionHolder = () -> dataSource.getConnection();

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    @Test
    @DisplayName("Test find users within range")
    void testgetUsersWithinSalaryRange() {
        // add userResult to list
        List<UserResult> userResults = new ArrayList<>();
        UserResult user = new UserResult("steve", 3254);
        UserResult user1 = new UserResult("paul", 1500);

        userResults.add(user);
        userResults.add(user1);

        // add users to list
        List<UserDB> users = new ArrayList<>();
        UserDB userDB = new UserDB(1l, "steve", 3254);
        UserDB userDB1 = new UserDB(2l, "paul", 1500);

        users.add(userDB);
        users.add(userDB1);

        doReturn(users).when(userRepository).getUsers();
        Output output = userService.getUsers();

        Assertions.assertEquals(userResults.size(), output.getResults().size());
        Assertions.assertEquals(userDB.getName(), output.getResults().get(0).getName());
    }


}
