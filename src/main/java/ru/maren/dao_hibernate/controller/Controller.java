package ru.maren.dao_hibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.maren.dao_hibernate.entity.Person;
import ru.maren.dao_hibernate.service.Service;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {
    private final Service service;

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city){
        return service.getPersonsByCity(city);
    }
}
