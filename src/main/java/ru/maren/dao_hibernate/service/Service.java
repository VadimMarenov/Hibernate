package ru.maren.dao_hibernate.service;

import lombok.AllArgsConstructor;
import ru.maren.dao_hibernate.entity.Person;
import ru.maren.dao_hibernate.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {
    private final Repository repository;

    public List<Person> getPersonsByCity(String city){
        return repository.getPersonsByCity(city);
    }
}
