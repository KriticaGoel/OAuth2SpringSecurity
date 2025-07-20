package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User extends BaseModel{

    @Column(unique = true,length = 50)
    private String username;
    @Column(length = 500)
    private String password;
    @Column(length = 100,unique = true)
    private String email;
    @Column(length = 15,unique = true)
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name ="user_id"),
            inverseJoinColumns = @JoinColumn(name ="role_id")
    )
    private List<Role> roles = new ArrayList<>();
}
