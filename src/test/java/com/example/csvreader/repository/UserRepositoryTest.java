package com.example.csvreader.repository;


import com.example.csvreader.model.UserDB;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.DBUnitExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
@ExtendWith({DBUnitExtension.class, SpringExtension.class})
public class UserRepositoryTest {

    @Autowired
    private DataSource dataSource;
    public ConnectionHolder connectionHolder = () -> dataSource.getConnection();
    @Autowired
    private UserRepository userRepository;

    @Test
    @DataSet("users.yml")
    void testSaveUsers() {
        UserDB userDB = new UserDB(1l, "steven", 3151.52);
        UserDB userDB1 = userRepository.save(userDB);
        Assertions.assertEquals(userDB.getName(), userDB1.getName(), "names from database match");
    }

    @Test
    @DataSet("users.yml")
    void testgetUsersWitinSalaryRange() {
        List<UserDB> users = userRepository.findAllBySalaryBetween(0, 4000);
                //userRepository.getUsers();
        Assertions.assertEquals(2, users.size(), "only 2 salaries fall within range");
    }
}
