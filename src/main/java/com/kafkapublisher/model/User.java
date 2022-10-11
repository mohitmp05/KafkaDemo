package com.kafkapublisher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    private Long id;
    private String name;
    private int phone;
    private String address;
}
