package com.example.rest_service; // Includes itself within this package

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue
    private long ID;
    
    private String name;
    private String[] type;

    public Pokemon(String name, String[] type) {
        this.name = name;
        this.type = type;
    }

    public long getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String[] getType() {
        return this.type;
    }

    public void setID(Long id) {
        this.ID = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String[] type) {
        this.type = type;
    }

}  