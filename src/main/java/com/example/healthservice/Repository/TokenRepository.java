package com.example.healthservice.Repository;

import com.example.healthservice.Model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {

    List<Token> findByGenerationTime(LocalDate date);
}
