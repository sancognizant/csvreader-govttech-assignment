package com.example.csvreader.repository;


import com.example.csvreader.model.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDB, Long> {

  // String query = "SELECT u FROM UserDB u WHERE u.salary BETWEEN 0 and 4000 order by u.salary";

//    @Query(query)
//    List<UserDB> getUsers();

    List <UserDB> findAllBySalaryBetween(double start, double end);
}
