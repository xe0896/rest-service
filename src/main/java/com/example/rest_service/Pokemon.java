package com.example.rest_service; // Includes itself within this package

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue

}  