package com.example.csvreader.Utils;

import com.example.csvreader.model.Output;
import com.example.csvreader.model.UserDB;
import com.example.csvreader.model.UserResult;

import java.util.ArrayList;
import java.util.List;

public final class Utility {

    private Utility() {}

    public final static Output getOutPut(List<UserDB> users) {
        Output output = new Output();
        List<UserResult> userList = new ArrayList<>();

        users.forEach(userDB -> {
            userList.add(new UserResult(userDB.getName(), userDB.getSalary()));
        });

        output.setResults(userList);
        return output;
    }

}
