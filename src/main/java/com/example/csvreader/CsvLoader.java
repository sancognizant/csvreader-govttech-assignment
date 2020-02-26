package com.example.csvreader;

import com.example.csvreader.Utils.CSVFILEPROCESSOR;
import com.example.csvreader.model.User;
import com.example.csvreader.model.UserDB;
import com.example.csvreader.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/* Get the data from the csv file and then convert the string salary to double and persist to database
 */
@Component
public class CsvLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<User> users = CSVFILEPROCESSOR.read(User.class);
        users.forEach(user -> {
            double salary = Double.parseDouble(user.getSalary());
            UserDB userDB = new UserDB(user.getName(), salary);
            userRepository.save(userDB);

        });
        System.out.println("Persisted data successfully");
    }
}
