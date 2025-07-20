package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

import jakarta.persistence.CascadeType;

@Data
@Entity
public class Token extends BaseModel{

    private String value;
    private Date expiryDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;


}
