package com.jforce.selenium.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

    @Id
    private int id;
    private String username;
    private String role;
    
    @Column(name = "is_active")
    private boolean isActive;
    private String password;
    private String email;
}
