package ru.maren.dao_hibernate.service;

import lombok.AllArgsConstructor;
import ru.maren.dao_hibernate.entity.Person;
import ru.maren.dao_hibernate.repository.PersonRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {
    private final PersonRepository repository;

    public List<Person> getPersonsByCity(String city){
        return repository.findByCityOfLiving(city);
    }
    public List<Person> getPersonsByAgeLessThan(int age){
        return repository.findByAgeLessThanOrderByAge(age);
    }
    public Optional<Person> getPersonByNameAndSurname(String name, String surname){
        return repository.findByNameAndSurname(name, surname);
    }
    public Person save(Person person){
        return repository.save(person);
    }
    public void delete(Person person){
        repository.delete(person);
    }
    public void deleteById(int id){
        repository.deleteById(id);
    }
}
