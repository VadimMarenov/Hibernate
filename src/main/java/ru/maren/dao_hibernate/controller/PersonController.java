package ru.maren.dao_hibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.maren.dao_hibernate.entity.Person;
import ru.maren.dao_hibernate.service.Service;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonController {
    private final Service service;

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city){
        return service.getPersonsByCity(city);
    }
    @GetMapping("/by-age-less-than")
    public List<Person> getPersonsByAgeLessThan(@RequestParam int age){
        return service.getPersonsByAgeLessThan(age);
    }
    @GetMapping("/by-name-and-surname")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname){
        return service.getPersonByNameAndSurname(name, surname);
    }
    @PostMapping("/save")
    public Person save(@RequestBody Person person){
        return service.save(person);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody Person person){
        service.delete(person);
    }

    @DeleteMapping("/delete-by-id")
    public void deleteById(@RequestParam int id){
        service.deleteById(id);
    }
}
