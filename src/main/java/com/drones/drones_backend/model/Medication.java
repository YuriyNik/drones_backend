package com.drones.drones_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medications")
public class Medication {

    @Id
  //  @Pattern(regexp = "^[A-Z0-9_]+$")
    private String code;

 //   @Pattern(regexp = "^[a-zA-Z0-9_-]+$")
    private String name;
    @Column(name = "weight", nullable = false)
    private int weight;
    public Medication(String code,String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.code = code;
    }
    public Medication() {

    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
