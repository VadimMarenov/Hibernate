package ru.maren.dao_hibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.maren.dao_hibernate.entity.Person;
import ru.maren.dao_hibernate.service.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonController {
    private final Service service;

    @PostAuthorize("hasAnyRole('ROLE_READ')")
    @GetMapping("/hi")
    public String getHi(){
        return "hi";
    }
    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/hi-user")
    public String getHiUser(String username){
        return "Hi " + username;
    }
    @Secured("ROLE_READ")
    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city){
        return service.getPersonsByCity(city);
    }
    @Secured("ROLE_READ")
    @GetMapping("/by-age-less-than")
    public List<Person> getPersonsByAgeLessThan(@RequestParam int age){
        return service.getPersonsByAgeLessThan(age);
    }
    @Secured("ROLE_READ")
    @GetMapping("/by-name-and-surname")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname){
        return service.getPersonByNameAndSurname(name, surname);
    }
    @RolesAllowed("ROLE_WRITE")
    @PostMapping("/save")
    public Person save(@RequestBody Person person){
        return service.save(person);
    }
    @PreAuthorize("hasAnyRole('ROLE_DELETE') or hasAnyRole('ROLE_WRITE')")
    @DeleteMapping("/delete")
    public void delete(@RequestBody Person person){
        service.delete(person);
    }
    @PreAuthorize("hasAnyRole('ROLE_DELETE')")
    @DeleteMapping("/delete-by-id")
    public void deleteById(@RequestParam int id){
        service.deleteById(id);
    }
}
