package com.example.model;

import com.example.utility.enums.State;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date creationDate;
    private Date modificationDate;
    private String createdBy;
    private String modifiedBy;
    @Enumerated(EnumType.STRING)
    private State state;
}
