package com.example.rest_service; // Includes itself within this package

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Ensures persistence within the JPA database 
@Table(name = "pokemon") // Names JPA database, not very useful as default is the entities name which is Pokemon, no different to pokemon
public class Pokemon {
    @Id // Ensures ID is the primary key
    @GeneratedValue // Ensures uniqueness of primary key
    private long ID;
    
    private String name;
    private String[] type;

    public Pokemon(String name, String[] type) {
        this.name = name;
        this.type = type;
    }

    /* Getter methods */
    public long getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String[] getType() {
        return this.type;
    }

    /* Setter methods */
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