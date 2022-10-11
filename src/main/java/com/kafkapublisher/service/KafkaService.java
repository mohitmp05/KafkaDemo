package com.kafkapublisher.service;

import com.kafkapublisher.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaService {

    List<User> list = List.of(
            new User (101L, "Mohit",98975465,"Lucknow"),
            new User (102L, "Prasanth",88535165,"Bangalore"),
            new User (103L, "Aakash",69975465,"Delhi")
    );

    public User getUser(Long id) {
        return list.stream().filter(user -> user.getId().equals(id)).findAny().orElse(null);
    }
}
