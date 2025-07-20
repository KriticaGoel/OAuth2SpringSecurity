package com.example.repository;

import com.example.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {

    Token findByValueAndExpiryDateAfter(String token, Date date);
}


