package com.example.csvreader.service;

import com.example.csvreader.model.Output;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Output getUsers();
}
