package com.example.model;

import com.example.utility.enums.State;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private Date creationDate;
    @LastModifiedDate
    private Date modificationDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;
    @Enumerated(EnumType.STRING)
    private State state;
}
