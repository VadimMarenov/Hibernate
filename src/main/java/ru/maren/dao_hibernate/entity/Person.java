package ru.maren.dao_hibernate.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")
@Entity
public class Person implements Serializable{
    @Id
    private String name;
    @Id
    private String surname;
    @Id
    private int age;
    private String phoneNumber;
    private String cityOfLiving;

}
