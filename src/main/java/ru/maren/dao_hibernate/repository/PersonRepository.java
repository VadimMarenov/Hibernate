package ru.maren.dao_hibernate.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.maren.dao_hibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("select p from Person p where p.cityOfLiving = :city_of_living")
    List<Person> findByCityOfLiving(@Param("city_of_living") String city);
    @Query("select p from Person p where p.age < :age order by p.age")
    List<Person> findByAgeLessThanOrderByAge(@Param("age") int age);
    @Query("select p from Person p where p.name = :name and p.surname = :surname")
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

}
