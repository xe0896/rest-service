package com.example.rest_service;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PokemonRepo extends JpaRepository<Pokemon, Long> {}
    