package com.phonemanagement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String producer;
    private String model;
    private double price;
}
