package com.example.csvreader.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
public class Output {

    private List<UserResult> results;
}
