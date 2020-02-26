package com.example.csvreader.service;

import com.example.csvreader.Utils.Utility;
import com.example.csvreader.model.Output;
import com.example.csvreader.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Output getUsers() {
        return Utility.getOutPut(userRepository.getUsers());
    }
}
